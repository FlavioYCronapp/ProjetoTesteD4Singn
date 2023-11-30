package blockly.Assinaturas;
import java.util.ArrayList;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import cronapi.CronapiMetaData;
import cronapi.CronapiMetaData.ObjectType;
import cronapi.ParamMetaData;
import cronapi.Var;
/**
 * Descrição da Função ...
 *
 * @author Fábrica
 * @version 1.0
 * @since 2022-05-25
 *
 */
@CronapiMetaData(categoryName = "Assinaturas")
public class Assinaturas {
    @CronapiMetaData(type = "function", name = "Seleciona Ambiente", description = "Seleciona o ambiente que será utilizado, isso implica no host do serviço.")
    public static String SelecionaAmbiente(@ParamMetaData(type = ObjectType.OBJECT, description = "Ambiente", blockType = "util_dropdown",
    keys = {"PRODUCTION", "SANDBOX"}, values = {"PRODUCTION", "SANDBOX"}) String env
    ) throws Exception {
        String host;
        if(env == "PRODUCTION"){
            host = "https://secure.d4sign.com.br";
        } else {
            host = "https://sandbox.d4sign.com.br";
        }
        return host;
    }
    @CronapiMetaData(type = "function", name = "Lista Cofres", description = "Lista cofres do ambiente", returnType = ObjectType.OBJECT)
    public static String ListaCofres(@ParamMetaData(description = "Ambiente: Ambiente requisitado") String baseURL,
    @ParamMetaData(description = "Token: Seu token da api") String tokenAPI,
    @ParamMetaData(description = "CryptKey: Seu crypt key") String cryptKey
    ) throws HttpStatusCodeException, JSONException {
        try {
            String result = "";
            String Url = baseURL + "/api/v1/safes?tokenAPI=" + tokenAPI + "&cryptKey=" + cryptKey;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>("", headers); 
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(Url, HttpMethod.GET, request, String.class);
            HttpStatus statusCode = response.getStatusCode();
            if (statusCode == HttpStatus.OK) {
                result = response.getBody();
            }
            return result;
        } catch (HttpStatusCodeException e) {
            JSONObject error = new JSONObject(e.getResponseBodyAsString());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, error.getString("error_description"));
        }       
    }
    @CronapiMetaData(type = "function", name = "Listar Pastas", description = "Lista pastas do cofre", returnType = ObjectType.OBJECT)
    public static String ListarPastas(@ParamMetaData(description = "Ambiente: Ambiente requisitado") String baseURL,
    @ParamMetaData(description = "Token API: Seu token da api") String tokenAPI,
    @ParamMetaData(description = "Id Cofre: UUid safe do cofre") String idCofre,
    @ParamMetaData(description = "CryptKey: Seu crypt key") String cryptKey
    ) throws HttpStatusCodeException, JSONException {
        try {
            String result = "";
            String Url = baseURL + "/api/v1/folders/" + idCofre + "/find?tokenAPI=" + tokenAPI + "&cryptKey=" + cryptKey;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>("", headers); 
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(Url, HttpMethod.GET, request, String.class);
            HttpStatus statusCode = response.getStatusCode();
            if (statusCode == HttpStatus.OK) {
                result = response.getBody();
            }
            return result;
        } catch (HttpStatusCodeException e) {
            JSONObject error = new JSONObject(e.getResponseBodyAsString());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, error.getString("error_description"));
        }       
    }
    @CronapiMetaData(type = "function", name = "Criar Pasta", description = "Criar pasta em um cofre específico", returnType = ObjectType.OBJECT)
    public static String CriarPasta(@ParamMetaData(description = "Ambiente: Ambiente requisitado") String baseURL,
    @ParamMetaData(description = "Token API: Seu token da api") String tokenAPI,
    @ParamMetaData(description = "Id Cofre: UUid safe do cofre") String idCofre,
    @ParamMetaData(description = "CryptKey: Seu crypt key") String cryptKey,
    @ParamMetaData(description = "Nome da pasta: Nome da pasta") String folderName
    ) throws HttpStatusCodeException, JSONException {
        try {
            String result = "";
            String Url = baseURL + "/api/v1/folders/" + idCofre + "/create?tokenAPI=" + tokenAPI + "&cryptKey=" + cryptKey;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            JSONObject bodyRequest = new JSONObject();
            bodyRequest.put("folder_name", folderName);
            HttpEntity<String> request = new HttpEntity<>(bodyRequest.toString(), headers); 
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(Url, HttpMethod.POST, request, String.class);
            HttpStatus statusCode = response.getStatusCode();
            if (statusCode == HttpStatus.OK) {
                result = response.getBody();
            }
            return result;
        } catch (HttpStatusCodeException e) {
            JSONObject error = new JSONObject(e.getResponseBodyAsString());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, error.getString("error_description"));
        }       
    }
    @CronapiMetaData(type = "function", name = "Listar Documentos", description = "Listar documentos de cofres", returnType = ObjectType.OBJECT)
    public static String ListarDocumetos(@ParamMetaData(description = "Ambiente: Ambiente requisitado") String baseURL,
    @ParamMetaData(description = "Token API: Seu token da api") String tokenAPI,
    @ParamMetaData(description = "CryptKey: Seu crypt key") String cryptKey
    ) throws HttpStatusCodeException, JSONException {
         try {
            String result = "";
            String Url = baseURL + "/api/v1/documents?tokenAPI=" + tokenAPI + "&cryptKey=" + cryptKey;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>("", headers); 
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(Url, HttpMethod.GET, request, String.class);
            HttpStatus statusCode = response.getStatusCode();
            if (statusCode == HttpStatus.OK) {
                result = response.getBody();
            }
            return result;
        } catch (HttpStatusCodeException e) {
            JSONObject error = new JSONObject(e.getResponseBodyAsString());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, error.getString("error_description"));
        }       
    }

     @CronapiMetaData(type = "function", name = "Enviar para assinatura", description = "Enviar documento para assinatura", returnType = ObjectType.OBJECT)
    public static String EnviarParaAssinatura(@ParamMetaData(description = "Ambiente: Ambiente requisitado") String baseURL,
    @ParamMetaData(description = "Token API: Seu token da api") String tokenAPI,
    @ParamMetaData(description = "CryptKey: Seu crypt key") String cryptKey,
    @ParamMetaData(description = "Id Documento: UUid document do documento") String idDocument
    ) throws HttpStatusCodeException, JSONException {
        try {
            String result = "";
            String Url = baseURL + "/api/v1/documents/" + idDocument + "/sendtosigner?tokenAPI=" + tokenAPI + "&cryptKey=" + cryptKey;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            JSONObject bodyRequest = new JSONObject();
            bodyRequest.put("message", "\"segue para assinatura\"");
            bodyRequest.put("workflow", 0);
            bodyRequest.put("skip_email", 0);
            HttpEntity<String> request = new HttpEntity<>(bodyRequest.toString(), headers); 
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(Url, HttpMethod.POST, request, String.class);
            HttpStatus statusCode = response.getStatusCode();
            if (statusCode == HttpStatus.OK) {
                result = response.getBody();
            }
            return result;
        } catch (HttpStatusCodeException e) {
            JSONObject error = new JSONObject(e.getResponseBodyAsString());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, error.getString("error_description"));
        }       
    }

	 @CronapiMetaData(type = "function", name = "Upload documento", description = "Realiza upload de um documento", returnType = ObjectType.OBJECT)
    public static String UploadDocumento(@ParamMetaData(description = "Ambiente: Ambiente requisitado") String baseURL,
    @ParamMetaData(description = "Token API: Seu token da api") String tokenAPI,
    @ParamMetaData(description = "CryptKey: Seu crypt key") String cryptKey,
    @ParamMetaData(description = "Id Cofre: UUid do cofre") String idCofre,
	@ParamMetaData(description = "Id Pasta: Id pasta (Opcional)") String idPasta,
	@ParamMetaData(description = "Nome arquivo: Nome do arquivo") String nomeArquivo,
	@ParamMetaData(description = "Base64: Base64 do arquivo") String base64,
	@ParamMetaData(description = "Tipo arquivo: Mime type do arquivo") String mimeType
    ) throws HttpStatusCodeException, JSONException {
        try {
            String result = "";
            String Url = baseURL + "/api/v1/documents/" + idCofre + "/uploadbinary?tokenAPI=" + tokenAPI + "&cryptKey=" + cryptKey;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            JSONObject bodyRequest = new JSONObject();
            bodyRequest.put("base64_binary_file", base64);
            bodyRequest.put("mime_type", mimeType);
            bodyRequest.put("name", nomeArquivo);
			bodyRequest.put("uuid_folder", idPasta);
            HttpEntity<String> request = new HttpEntity<>(bodyRequest.toString(), headers); 
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(Url, HttpMethod.POST, request, String.class);
            HttpStatus statusCode = response.getStatusCode();
            if (statusCode == HttpStatus.OK) {
                result = response.getBody();
            }
            return result;
        } catch (HttpStatusCodeException e) {
            JSONObject error = new JSONObject(e.getResponseBodyAsString());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, error.getString("error_description"));
        }       
    }

     @CronapiMetaData(type = "function", name = "Cancelar documento", description = "Cancelamento de documento", returnType = ObjectType.OBJECT)
    public static String CancelarDocumento(@ParamMetaData(description = "Ambiente: Ambiente requisitado") String baseURL,
    @ParamMetaData(description = "Token API: Seu token da api") String tokenAPI,
    @ParamMetaData(description = "CryptKey: Seu crypt key") String cryptKey,
    @ParamMetaData(description = "Id Documento: UUid_document do documento") String idDocument
    ) throws HttpStatusCodeException, JSONException {
        try {
            String result = "";
            String Url = baseURL + "/api/v1/documents/" + idDocument + "/cancel?tokenAPI=" + tokenAPI + "&cryptKey=" + cryptKey;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            JSONObject bodyRequest = new JSONObject();
            bodyRequest.put("folder_name", idDocument);
            HttpEntity<String> request = new HttpEntity<>(bodyRequest.toString(), headers); 
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(Url, HttpMethod.POST, request, String.class);
            HttpStatus statusCode = response.getStatusCode();
            if (statusCode == HttpStatus.OK) {
                result = response.getBody();
            }
            return result;
        } catch (HttpStatusCodeException e) {
            JSONObject error = new JSONObject(e.getResponseBodyAsString());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, error.getString("error_description"));
        }       
    }
     @CronapiMetaData(type = "function", name = "Objeto Signatário", description = "Cria objeto de signiatario", returnType = ObjectType.OBJECT) public static Signatario ObjetoSignatario(
    @ParamMetaData(description = "Email: Email do signatario") String email,
    @ParamMetaData(description = "Ação: Ação de assinatura") Integer act,
    @ParamMetaData(type = ObjectType.OBJECT, description = "Possui CPF: Se o signatário é estrangeiro", blockType = "util_dropdown",
    keys = {"0", "1"}, values = {"SIM", "NÃO"}) String foreign,
    @ParamMetaData(description = "Assinar via ICP: certificado ICP") Boolean certificadoicpbr,
    @ParamMetaData(description = "Assinar via apresentação de documento com foto: Assinar com documento com foto") Boolean docauth,
    @ParamMetaData(description = "Assinar via apresentação de documento com foto e selfie: Assinar com documento e selfie") Boolean docauthandselfie,
    @ParamMetaData(description = "Assinar presencialmente: assinatura presencial") Boolean assinatura_presencial,
     @ParamMetaData(description = "Assinar via videoSelfie: Assinatura por video Selfie") Integer videoselfie
    ) throws Exception {
        Signatario signatario = new Signatario(email, act, Integer.parseInt(foreign), certificadoicpbr, assinatura_presencial, docauth, docauthandselfie, videoselfie, foreign, foreign, foreign, foreign, foreign, foreign);
        return signatario;
    }
     @CronapiMetaData(type = "function", name = "Cadastrar signatários", description = "Cadastro de signiatarios ao documento", returnType = ObjectType.OBJECT)
    public static String CadastrarSignatario(@ParamMetaData(description = "Ambiente: Ambiente requisitado") String baseURL,
    @ParamMetaData(description = "Token API: Seu token da api") String tokenAPI,
    @ParamMetaData(description = "CryptKey: Seu crypt key") String cryptKey,
    @ParamMetaData(description = "Id Documento: UUid_document do documento") String idDocument,
    @ParamMetaData(description = "Lista signatários: UUid_document do documento") String signatarios
    ) throws HttpStatusCodeException, JSONException {
        try {
            String result = "";
            String Url = baseURL + "/api/v1/documents/" + idDocument + "/createlist?tokenAPI=" + tokenAPI + "&cryptKey=" + cryptKey;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            JSONObject bodyRequest = new JSONObject();
            bodyRequest.put("signers", signatarios);
            HttpEntity<String> request = new HttpEntity<>(bodyRequest.toString(), headers); 
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(Url, HttpMethod.POST, request, String.class);
            HttpStatus statusCode = response.getStatusCode();
            if (statusCode == HttpStatus.OK) {
                result = response.getBody();
            }
            return result;
        } catch (HttpStatusCodeException e) {
            JSONObject error = new JSONObject(e.getResponseBodyAsString());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, error.getString("error_description"));
        }
    }
     @CronapiMetaData(type = "function", name = "Cadastrar Webhook", description = "Criar pasta em um cofre específico", returnType = ObjectType.OBJECT)
    public static String CadastrarWebhook(@ParamMetaData(description = "Ambiente: Ambiente requisitado") String baseURL,
    @ParamMetaData(description = "Token API: Seu token da api") String tokenAPI,
    @ParamMetaData(description = "CryptKey: Seu crypt key") String cryptKey,
    @ParamMetaData(description = "Id do documento: id do documento") String idDocumento,
    @ParamMetaData(description = "URL: url do webhook") String urlWebhook
    ) throws HttpStatusCodeException, JSONException {
        try {
            String result = "";
            String Url = baseURL + "/api/v1/documents/" + idDocumento + "/webhooks?tokenAPI=" + tokenAPI + "&cryptKey=" + cryptKey;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            JSONObject bodyRequest = new JSONObject();
            bodyRequest.put("url", urlWebhook);
            HttpEntity<String> request = new HttpEntity<>(bodyRequest.toString(), headers); 
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(Url, HttpMethod.POST, request, String.class);
            HttpStatus statusCode = response.getStatusCode();
            if (statusCode == HttpStatus.OK) {
                result = response.getBody();
            }
            return result;
        } catch (HttpStatusCodeException e) {
            JSONObject error = new JSONObject(e.getResponseBodyAsString());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, error.getString("error_description"));
        }       
    }

        @CronapiMetaData(type = "function", name = "alterar email signatario", description = "Alterar email do signatario", returnType = ObjectType.OBJECT)
    public static String AlterarEmailSignatario(@ParamMetaData(description = "Ambiente: Ambiente requisitado") String baseURL,
    @ParamMetaData(description = "Token API: Seu token da api") String tokenAPI,
    @ParamMetaData(description = "CryptKey: Seu crypt key") String cryptKey,
    @ParamMetaData(description = "Id Documento: UUid_document do documento") String idDocument,
    @ParamMetaData(description = "antigo Email Signatario: Email antigo a ser alterado") String email_before,
    @ParamMetaData(description = "novo Email Signatario: novo email a ser cadastrado ") String email_after,
    @ParamMetaData(description = "chave do signatario: chave de assinatura signatario ") String key_signer
   

    ) throws HttpStatusCodeException, JSONException {
        try {
            String result = "";
            String Url = baseURL + "/api/v1/documents/" + idDocument + "/changeemail?tokenAPI=" + tokenAPI + "&cryptKey=" + cryptKey;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            JSONObject bodyRequest = new JSONObject();
            bodyRequest.put("email-before", email_before);
            bodyRequest.put("email-after", email_after);
            bodyRequest.put("Key-signer", key_signer);
                      
            HttpEntity<String> request = new HttpEntity<>(bodyRequest.toString(), headers); 
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(Url, HttpMethod.POST, request, String.class);
            HttpStatus statusCode = response.getStatusCode();
            if (statusCode == HttpStatus.OK) {
                result = response.getBody();
            }
            return result;
        } catch (HttpStatusCodeException e) {
            JSONObject error = new JSONObject(e.getResponseBodyAsString());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, error.toString());
        }
    }
}
