function assinar(){
    window.addEventListener("message", (event) => {
       if (event.data === "signed") {
           alert('ASSINADO'); //ou redirecionar o usuário para outra página.
       }
       if (event.data === "wrong-data") {
           alert('USUÁRIO CLICOU NO LINK: Meus dados estão errados.'); //ou redirecionar o usuário para uma página onde poderá alterar os seus dados.
       }
   }, false);
}