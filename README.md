# Site-E-Commerce

Desenvolvido na diciplina de programação Web, o código é referente a um site e-commerce simples onde desempenha as funcionalidades simples como, galeria de produtos, crud para produtos e usários por parte de uma login administrador, carrinho de compras para um usuário do tipo cliente.

## Configuração

Importe o projeto para seu Eclipse como um projeto Maven e espere até que tenha baixado todas as dependências, você precisará ainda ter instalado em sua maquina o Postgresql e o Apache TomCat versão 8.5.

No Postgresql, através da interface do pgAdmin ou terminal crie um banco de dados com o nome **loja**.
Reveja o arquivo application.properties na pasta resourses do projeto, para confirações caso seu postgres não disponha da porta padrão 5432 e/ou sua senha de acesso seja diferente de **postgres**

## Instalando o TomCat 8.5

Realize do download atraves do link: [TomCat 8.5](https://tomcat.apache.org/download-80.cgi), Esteja atento a versão do seu sistema operacional.
Após realizado o download descompacte a pasta do tomcat para um local acessivel, agora no Eclipse em Quick Access digite servers e adicione e clique em adiocar novo server, e seguir as próximas etapas. 
