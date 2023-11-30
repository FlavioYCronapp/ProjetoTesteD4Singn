(function() {
  'use strict';

  this.cronapi = this.cronapi || {};

   /**
   * @categoryName Assinatura
   */
  this.cronapi.myfunctions = this.cronapi.myfunctions || {};
  

   /**
   * @type function
   * @name Obtêm Ambiente
   * @description setAndGetEnvironment
   * @multilayer false
   * @param {ObjectType.STRING} input Param Description
   * @returns {ObjectType.STRING}
   */
  this.cronapi.myfunctions.setAndGetEnvironment = function(/** @type {ObjectType.STRING} @description Ambiente @blockType util_dropdown @keys PRODUCTION|SANDBOX @values PRODUCTION|SANDBOX */ env) {
    var host = "";
    if(env == 'PRODUCTION'){
      host = "https://secure.d4sign.com.br";
    } else {
      host = "https://sandbox.d4sign.com.br";
    }
    return host;
  };



  /**
   * @type function
   * @name Visualiza Documento
   * @description setEnvironment
   * @multilayer false
   */
  this.cronapi.myfunctions.viewerDocument = function(/** @type {ObjectType.OBJECT} @description Id: id componente @blockType ids_from_screen*/ idComponent,/** @type {ObjectType.STRING} @description Ambiente: Ambiente selecionado */ env,/** @type {ObjectType.STRING} @description Chave: Chave de assinatura */key,/** @type {ObjectType.STRING} @description Destinatário: Quem irá receber o documento para assinatura */signer_email) {
    let host = env + "/embed/viewblob";
    let signer_disable_preview = 0;
    let signer_display_name = "";
    let signer_documentation = "";
    let signer_birthday = "";
    let signer_key_signer = "";
    var container = idComponent;
    var width = '1025';
    var height = '500';
    var is_safari = navigator.userAgent.indexOf('Safari') > -1;
    var is_chrome = navigator.userAgent.indexOf('Chrome') > -1;
    if ((is_chrome) && (is_safari)) {is_safari = false;}  
    if (is_safari) {
        if (!document.cookie.match(/^(.*;)?\s*fixed\s*=\s*[^;]+(.*)?$/)) {
            document.cookie = 'fixed=fixed; expires=Tue, 19 Jan 2038 03:14:07 UTC; path=/';
            var url = document.URL;
            var str = window.location.search;
            var param = str.replace("?", "");
            if (url.indexOf("?")>-1){
                url = url.substr(0,url.indexOf("?"));
            }
           // window.location.replace("https://secure.d4sign.com.br/embed/safari_fix?param="+param+'&r='+url);
        }
    }
    var iframe = document.createElement("iframe");
    if (signer_key_signer === ''){
        iframe.setAttribute("src", host+'/'+key+'?email='+signer_email+'&display_name='+signer_display_name+'&documentation='+signer_documentation+'&birthday='+signer_birthday+'&disable_preview='+signer_disable_preview);
    }else{
        iframe.setAttribute("src", host+'/'+key+'?email='+signer_email+'&display_name='+signer_display_name+'&documentation='+signer_documentation+'&birthday='+signer_birthday+'&disable_preview='+signer_disable_preview+'&key_signer='+signer_key_signer);
    }
    iframe.setAttribute("id", 'd4signIframe');
    iframe.setAttribute("width", width);
    iframe.setAttribute("height", height);
   
    iframe.style.border = 0;
    iframe.setAttribute("allow", 'geolocation');
    var cont = document.getElementById(container);
    cont.appendChild(iframe);
    window.addEventListener("message", (event) => {
        if (event.data === "signed") {
            alert('ASSINADO');
        }
        if (event.data === "wrong-data") {
            alert('DADOS ERRADOS');
        }
    }, false);
  };

  /**
   * @type function
   * @name Lista cofres
   * @description Lista cofres
   * @multilayer false
   */
  this.cronapi.myfunctions.getSafes = function( /* @type {ObjectType.STATEMENTSENDER} @description Resposta */ safesResponse,/** @type {ObjectType.STRING} @description Token: Seu token */token,/** @type {ObjectType.STRING} @description CryptKey: Seu crypt key */cryptKey,/** @type {ObjectType.STRING} @description Ambiente: Ambiente que o método será utilizado */environment) {
    
    let url = environment + '/api/v1/safes?tokenAPI=' + token + '&cryptKey=' + cryptKey;

    this.cronapi.util.getURLFromOthers('GET', 'application/json', url, "", "", async function(sender_item) {
      let item = sender_item;
    safesResponse(item);
  }.bind(this), async function(sender_item) {
      let item = sender_item;
    safesResponse(item);
  }.bind(this));
   
  }

 /**
   * @type function
   * @name Recebe Arquivo
   * @description Convert file in blob
   * @multilayer false
   */
  this.cronapi.myfunctions.ConvertFileToObject = function(/** @type {ObjectType.OBJECT} @description Id: id componente @blockType ids_from_screen*/ id, /* @type {ObjectType.STATEMENTSENDER} @description retorno */ retorno) {
    var reader = new FileReader();
    var file = document.getElementById(id).files[0];
    if(file != null && file != undefined && file != ""){
      var filePos = (file.name).lastIndexOf(".");
      var fileName = (file.name).substr(0, filePos);
      var extension = (file.name).substr(filePos, file.name.length);
      if(file.type == null || file.type == undefined) {
        retorno({error: true})
        try {
          document.getElementById(id).files = {};
        } catch(err){
          console.log(err);
        }
      } else {
        reader.readAsDataURL(file);
        reader.onload = function () {
          let typeFile = ""
         if(file.type == "application/wps-office.pdf") typeFile = "application/pdf"
         else if(file.type == "application/wps-office.docx") typeFile = "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
         else typeFile = file.type
          let value = reader.result;
          let pos = value.indexOf("base64,");
          let finalB64 = value.substr(pos+7, value.length);
          let ret = {
            nome: fileName,
            tipoArquivo: typeFile,
            base64: finalB64
          }
          retorno(ret);
        };
        reader.onerror = function (error) {
          retorno({error: true});
        }
      }
    }
  };
  

}).bind(window)();
