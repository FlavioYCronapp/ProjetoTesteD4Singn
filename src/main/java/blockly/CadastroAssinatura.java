package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class CadastroAssinatura {

public static final int TIMEOUT = 300;

/**
 *
 * CadastroAssinatura
 *
 * @param email
 * @param dados
 * @param acao
 *
 * @author Flavio Yamane De Oliveira
 * @since 31/10/2022 10:16:34
 *
 */
public static Var Executar(@ParamMetaData(description = "email", id = "a3d5f13c") Var email, @ParamMetaData(description = "dados", id = "3f820757") Var dados, @ParamMetaData(description = "Acao", id = "88bfdf7e") Var Acao) throws Exception {
 return new Callable<Var>() {

   private Var icp = Var.VAR_NULL;
   private Var Doc = Var.VAR_NULL;
   private Var docFoto = Var.VAR_NULL;
   private Var Presencial = Var.VAR_NULL;
   private Var VideoSelfie = Var.VAR_NULL;
   private Var metodoAssinatura = Var.VAR_NULL;
   private Var WhatsApp = Var.VAR_NULL;
   private Var Sms = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;
   private Var err = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         if (
        Var.valueOf(
        cronapi.screen.Operations.getValueOfField(
        Var.valueOf("vars.combobox4669")).equals(
        Var.valueOf(1))).getObjectAsBoolean()) {
            System.out.println(
            Var.valueOf("ICP").getObjectAsString());
            icp =
            Var.valueOf(1);
            Doc =
            Var.valueOf(0);
            docFoto =
            Var.valueOf(0);
            Presencial =
            Var.valueOf(0);
            VideoSelfie =
            Var.valueOf(0);
        } else if (
        Var.valueOf(
        cronapi.screen.Operations.getValueOfField(
        Var.valueOf("vars.combobox4669")).equals(
        Var.valueOf(2))).getObjectAsBoolean()) {
            System.out.println(
            Var.valueOf("Presencial").getObjectAsString());
            icp =
            Var.valueOf(0);
            Doc =
            Var.valueOf(0);
            docFoto =
            Var.valueOf(0);
            Presencial =
            Var.valueOf(1);
            VideoSelfie =
            Var.valueOf(0);
        } else if (
        Var.valueOf(
        cronapi.screen.Operations.getValueOfField(
        Var.valueOf("vars.combobox4669")).equals(
        Var.valueOf(3))).getObjectAsBoolean()) {
            System.out.println(
            Var.valueOf("Doc com Foto").getObjectAsString());
            icp =
            Var.valueOf(0);
            Doc =
            Var.valueOf(1);
            docFoto =
            Var.valueOf(0);
            Presencial =
            Var.valueOf(0);
            Presencial =
            Var.valueOf(0);
            VideoSelfie =
            Var.valueOf(0);
        } else if (
        Var.valueOf(
        cronapi.screen.Operations.getValueOfField(
        Var.valueOf("vars.combobox4669")).equals(
        Var.valueOf(4))).getObjectAsBoolean()) {
            System.out.println(
            Var.valueOf("Doc + foto").getObjectAsString());
            icp =
            Var.valueOf(0);
            Doc =
            Var.valueOf(0);
            docFoto =
            Var.valueOf(1);
            Presencial =
            Var.valueOf(0);
            VideoSelfie =
            Var.valueOf(0);
        } else if (
        Var.valueOf(
        cronapi.screen.Operations.getValueOfField(
        Var.valueOf("vars.combobox4669")).equals(
        Var.valueOf(5))).getObjectAsBoolean()) {
            System.out.println(
            Var.valueOf("videoSelfie ").getObjectAsString());
            icp =
            Var.valueOf(0);
            Doc =
            Var.valueOf(0);
            docFoto =
            Var.valueOf(0);
            Presencial =
            Var.valueOf(0);
            VideoSelfie =
            Var.valueOf(1);
        } else if (
        Var.valueOf(
        cronapi.screen.Operations.getValueOfField(
        Var.valueOf("vars.combobox4669")).equals(
        Var.valueOf(6))).getObjectAsBoolean()) {
            System.out.println(
            Var.valueOf("assinatura por whats ").getObjectAsString());
            metodoAssinatura =
            Var.valueOf("whats");
            if (
            Var.valueOf(metodoAssinatura.equals(
            Var.valueOf("whats"))).getObjectAsBoolean()) {
                WhatsApp =
                cronapi.screen.Operations.getValueOfField(
                Var.valueOf("vars.NumeroCell"));
                Sms =
                Var.VAR_NULL;
            } else if (
            Var.valueOf(metodoAssinatura.equals(
            Var.valueOf("sms"))).getObjectAsBoolean()) {
                WhatsApp =
                Var.VAR_NULL;
                Sms =
                cronapi.screen.Operations.getValueOfField(
                Var.valueOf("vars.NumeroCell"));
            }
            icp =
            Var.valueOf(0);
            Doc =
            Var.valueOf(0);
            docFoto =
            Var.valueOf(0);
            Presencial =
            Var.valueOf(0);
            VideoSelfie =
            Var.valueOf(0);
        } else if (
        Var.valueOf(
        cronapi.screen.Operations.getValueOfField(
        Var.valueOf("vars.combobox4669")).equals(
        Var.valueOf(7))).getObjectAsBoolean()) {
            System.out.println(
            Var.valueOf("assinatura por SMS").getObjectAsString());
            metodoAssinatura =
            Var.valueOf("sms");
            if (
            Var.valueOf(metodoAssinatura.equals(
            Var.valueOf("whats"))).getObjectAsBoolean()) {
                WhatsApp =
                cronapi.screen.Operations.getValueOfField(
                Var.valueOf("vars.NumeroCell"));
                Sms =
                Var.VAR_NULL;
            } else if (
            Var.valueOf(metodoAssinatura.equals(
            Var.valueOf("sms"))).getObjectAsBoolean()) {
                Sms =
                cronapi.screen.Operations.getValueOfField(
                Var.valueOf("vars.NumeroCell"));
                Sms =
                Var.VAR_NULL;
            }
            icp =
            Var.valueOf(0);
            Doc =
            Var.valueOf(0);
            docFoto =
            Var.valueOf(0);
            Presencial =
            Var.valueOf(0);
            VideoSelfie =
            Var.valueOf(0);
        }
        item =
        Var.valueOf(blockly.Assinaturas.Assinaturas.ObjetoSignatario(
        Var.valueOf("flavio.yamane@cronapp.io").getTypedObject(String.class), Acao.getTypedObject(Integer.class),
        Var.valueOf("0").getTypedObject(String.class), icp.getTypedObject(Boolean.class), Doc.getTypedObject(Boolean.class), docFoto.getTypedObject(Boolean.class), Presencial.getTypedObject(Boolean.class), VideoSelfie.getTypedObject(Integer.class)));
        System.out.println(
        Var.valueOf("ABCDEF").getObjectAsString());
        System.out.println(item.getObjectAsString());
        item =
        Var.valueOf(blockly.Assinaturas.Assinaturas.CadastrarSignatario(
        Var.valueOf(blockly.Assinaturas.Assinaturas.SelecionaAmbiente(
        Var.valueOf("PRODUCTION").getTypedObject(String.class))).getTypedObject(String.class),
        Var.valueOf("live_11ef8758d18cfd0af519ea9eccc301c7e18ac76f54cedf9b5e0849f26bc1021c").getTypedObject(String.class),
        Var.valueOf("live_crypt_xr9MHgkH5BaYA4EDVCPHUD75YwDwE0X5").getTypedObject(String.class),
        Var.valueOf("d5b0aeee-c51f-4a69-b6c0-1c3ab26f6826").getTypedObject(String.class),
        cronapi.list.Operations.newList(item).getTypedObject(String.class)));
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
        Var.valueOf("cadastrado com sucesso"));
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         System.out.println(
        cronapi.util.Operations.getExceptionMessage(err).getObjectAsString());
        cronapi.util.Operations.throwException(
        Var.valueOf("erro ao cadastrar"));
     }
    return Var.VAR_NULL;
   }
 }.call();
}

}

