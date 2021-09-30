Criei isso aqui pra aprender a usar o Android Studio

é um gerador de memes semi-automatico pra memes da sam feito no Android Studio em Java

*Existem 4 grupos de Checkboxs
    -1 texto para primeira parte do meme
    -2 texto para segunda parte do meme
    -3 imagem de fundo do meme 
    -4 imagem da logo do meme

Automaticamente, quando voce marca uma hitbox de cada grupo as outras do mesmo grupo são desmarcadas. Fiz isso adicionando em Lists e depois chamando um metodo que faz o trabalho (só olhar o Activitymain).

*Existe também um EditTextBox para adicionar a terceira e ultima parte do meme.

Na classe existe 3 Strings para trabalhar e juntar as 3 partes do meme. o Metodo que faz isso é o 'montarMeme'

*Estrutura do meme

O meme é formado por 3 Imageview em um ConstraintLayout, uma sendo o fundo do meme, a outra sendo a logo do meme e a ultima sendo a barra branca. Por último, encima da barra branca, tem um TextView que é a frase do meme. Pra alterar cada imagem é facil, é apenas um sistema de if/else bem simples.

*captura do meme

Simplemente é feito um bitmap do ConstrainLayout onde esta o meme e depois isso é salvo na galeria (necessário permissão)

