#
#

@Interado
@Participante
Funcionalidade: Cadastrar Participante

@CadastrarParticipanteSucesso (I, II)
Esquema do Cenario: Cadastrar participante do tipo pessoa juridica com sucesso na plataforma fazendo vinculo ao cadastro no sistema corporativo de pessoas do banco  
	Dado que estou na plataforma de seguros para a criação de um participante "<pessoaExiste>"
	Quando informo os dados de cadastro de um novo participante do tipo pessoa "<tipoPessoa>"
	Entao devera ser realizado o cadastro na plataforma com status "<statusApp>"
	E devera ser realizado um novo cadastrado no sistema corporativo de pessoas do banco "<statusEQ3>"
	Exemplos:
		| tipoPessoa | statusApp | pessoaExiste | statusEQ3
		| JURIDICA	 |	200		 |	false		|	200
		| JURIDICA	 |	200		 |	true		|	200
				

@CadastrarParticipanteFalha
Esquema do Cenario: Cadastrar participante do tipo pessoa juridica com falha na plataforma quando ja existente
	Dado que estou na plataforma de seguros para a criação de um participante "<pessoaExiste>"
	Quando informo os dados de cadastro de um novo participante do tipo pessoa jurídica "<tipoPessoa>"
	Entao deverá ser realizado o cadastro na plataforma "<statusApp>"
	E devera ser realizado um novo cadastrado no sistema corporativo de pessoas do banco "<mensagemFalha>"
	Exemplos:
		| tipoPessoa | statusApp | pessoaExiste | statusEQ3
		| JURIDICA	 |	400		 |	false		|	200
		| JURIDICA	 |	200		 |	true		|	200