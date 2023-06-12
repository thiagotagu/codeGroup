# Avaliacao code group

Foi utilizado JAVA 11 + Springboot + bootstrap + maven + banco h2 (aplicacao foi desenvolvida em ANSI) + REST + JUNIT + swagger PARA DOCUMENTACAO DO REST

Aplicacao roda na Porta 8080 
http://localhost:8080/

Documentacao REST para inclusao de dados De Pessoa 
http://localhost:8080/swagger-ui/index.html#/

Foi criado um menu Lateral Simples, para acessar as funcionalidades 

Foi criada a funcionalidade de workflow para Transferir os Status do Projeto conforme Regra de negocio citado.


Foi criado uma class para Carga de dados FAKE para facilitar os teste e desenvolvimento. CargaMassaTesteFAKE

@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		carga.gerarCarga();
	}