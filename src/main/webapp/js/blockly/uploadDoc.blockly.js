window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.UploadDoc = window.blockly.js.blockly.UploadDoc || {};

/**
 * @function UploadDoc
 *
 * uploadDoc
 *
 *
 * @author Flavio Yamane De Oliveira
 * @since 08/09/2022 17:26:10
 *
 */
window.blockly.js.blockly.UploadDoc.UploadDocArgs = [];
window.blockly.js.blockly.UploadDoc.UploadDoc = async function() {
 var upload, item, nome, tipoArquivo, base64;
  //
  this.cronapi.myfunctions.ConvertFileToObject("crn-upload-document-363900", async function(sender_upload) {
      upload = sender_upload;
    //
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.Listar:fazer_upload', async function(sender_item) {
        item = sender_item;
    }.bind(this), nome, tipoArquivo, base64);
  }.bind(this));
}
