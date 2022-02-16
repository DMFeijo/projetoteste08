#language: pt
#encoding: iso-8859-1

Funcionalidade: Cadastro de empresas
 como um usuario do sistema 
 eu quero realizar cadastro de empresas 
 para que eu possa gerenciar empresas
 
 Esquema do Cenário: Definir tipo de cadstro de empresas
 Dado Acessar a pagina cadastro de empresas
 E informar nome fantasia "Loja Teste"
 E informar a razao sicial "Loja teste Ltda"
 E selecionar a categoria <categoria>
 E informar o CNPJ "17.699.615/0001-50"
 E informar a descricao da empresa "Vestuario infantil"
 Quando Realizar cadastro de empresa
 Entao o sistema exibe a mensagem "Empresa cadastrada com sucesso."
 
 Exemplos: 
| categoria              |
| "Empresa Parceira"     |
| "Fornecedor"           |
| "Prestador de Serviço" | 
 
 Cenário: Validacão de campos obrigatorios
Dado Acessar a pagina cadastro de empresas
Quando Realizar cadastro de empresa
Entao o sistema exibe a mensagem campo obrigatorio