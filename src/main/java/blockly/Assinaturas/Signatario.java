package blockly.Assinaturas;
public class Signatario {
    public String email;
    public Integer act;
    public Integer foreign;
    public Boolean certificadoicpbr;
    public Boolean assinatura_presencial;
    public Boolean docauth;
    public Boolean docauthandselfie;
    public Integer videoselfie;
    public String whatsapp_number;
    public String embed_smsnumber;
    public String embed_methodauth;
    public String email_before;
    public String email_after;
    public String key_signer;

    public Signatario(String email, Integer act, Integer foreign, Boolean certificadoicpbr, Boolean assinatura_presencial, Boolean docauth, Boolean docauthandselfie, Integer videoselfie, String embed_methodauth, String whatsapp_number, String embed_smsnumber, String email_before, String email_after, String key_signer) {
        this.email = email;
        this.act = act;
        this.foreign = foreign;
        this.certificadoicpbr = certificadoicpbr;
        this.assinatura_presencial = assinatura_presencial;
        this.docauth = docauth;
        this.docauthandselfie = docauthandselfie;
        this.videoselfie = videoselfie;
        this.embed_methodauth = embed_methodauth;
        this.whatsapp_number = whatsapp_number;
        this.embed_smsnumber = embed_smsnumber;
        this.email_before = email_before;
        this.email_after = email_after;
        this.key_signer = key_signer;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getAct() {
        return act;
    }
    public void setAct(Integer act) {
        this.act = act;
    }
    public Integer getForeign() {
        return foreign;
    }
    public void setForeign(Integer foreign) {
        this.foreign = foreign;
    }
    public Boolean getCertificadoicpbr() {
        return certificadoicpbr;
    }
    public void setCertificadoicpbr(Boolean certificadoicpbr) {
        this.certificadoicpbr = certificadoicpbr;
    }
    public Boolean getassinatura_presencial() {
        return assinatura_presencial;
    }
    public void setassinatura_presencial(Boolean assinatura_presencial) {
        this.assinatura_presencial = assinatura_presencial;
    }
     public Boolean getdocauth() {
        return docauth;
    }
    public void setdocauth(Boolean docauth) {
        this.docauth = docauth;
    }
      public Boolean getdocauthandselfie() {
        return docauthandselfie;
    }
    public void setdocauthandselfie(Boolean docauthandselfie) {
        this.docauthandselfie = docauthandselfie;
    }
      public Integer getvideoselfie() {
        return videoselfie;
    }
    public void setvideoselfie(Integer videoselfie) {
        this.videoselfie = videoselfie;
    }
     public String getwhatsapp_number() {
        return whatsapp_number;
    }
    public void setewhatsapp_number(String whatsapp_number) {
        this.whatsapp_number = whatsapp_number;
    }
public String getembed_smsnumber() {
        return embed_smsnumber;
    }
    public void setembed_smsnumber(String embed_smsnumber) {
        this.embed_smsnumber = embed_smsnumber;
    }
      public String getembed_methodauth() {
        return embed_methodauth;
    }
    public void setembed_methodauth(String embed_methodauth) {
        this.embed_methodauth = embed_methodauth;
    }

           public String getemail_before() {
        return email_before;
    }

    public void setemail_before(String email_before) {
        this.email_before = email_before;
    }

       public String getemail_after() {
        return email_after;
    }

    public void setemail_after(String email_after) {
        this.email_after = email_after;
    }

       public String getkey_signer() {
        return key_signer;
    }

    public void setkey_signer(String key_signer) {
        this.key_signer = key_signer;
    }
}