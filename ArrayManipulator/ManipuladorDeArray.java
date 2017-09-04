public class ManipuladorDeArray
{
    /**
     * Obtém a soma dos números do array.
     *
     * @param numeros O array contendo os números.
     * @return Retorna a soma dos números. Se o array estiver vazio retorna zero.
     */
    public int returnSum(int[] numbers) {
        int result = 0;
        
        for(int i = 0; i < numbers.length; i++)
            result += numbers[i];
        
        //for(int iteractions : numbers)
        //    result += iteractions;  
            
        return result;
    }

    /**
     * Obtém os números que estão em posições ímpares, ou seja, retorna os números das posições 1, 3, 5, etc.
     *
     * @param numeros Os números.
     * @return Retorna os números que estão em posições ímpares.
     */
    public int[] retorneDePosicoesImpares(int[] numbers) {
        int[] result = new int[numbers.length / 2];
        
        for(int i = 0; i < numbers.length; i++)
        {   
            if(i % 2 != 0)
                result[i/2] = numbers[i];
        }
        
        return result;
    }

    /**
     * Obtém o primeiro e o último número do array.
     *
     * @param numeros Os números.
     * @return Retorna um array de tamanho 2 onde o primeiro número é o primeiro número do array numeros e o segundo número é
     * o último número do array numeros. Caso o array tenha menos de dois números então retorna um array de tamanho zero.
     */
    public int[] retornePrimeiroEUltimo(int[] numbers) {
        int[] result;
        
        if(numbers.length < 2)
            result = new int[0];
        else
            result = new int[] { numbers[0], numbers[numbers.length - 1] };
        
        return result;
    }

    /**
     * Calcula quantas vezes um número aparece em um array.
     *
     * @param numeros Os números.
     * @param numero O número.
     * @return Retorna quantas vezes o numero aparece no array numeros.
     */
    public int retorneQuantasOcorrencias(int[] numbers, int number) {
        int result = 0;
        
        for(int i = 0; i < numbers.length; i++)
        {
            if(numbers[i] == number)
                result++;
        }
            
        return result;
    }

    /**
     * Obtém o maior número do array. Considere que o array sempre possui pelo menos um número.
     *
     * @param numeros Os números.
     * @return Retorna o maior número do array numeros.
     */
    public int retorneMaiorNumero(int[] numbers) {
        int result = numbers[0];
        
        for(int iteraction : numbers)
            if(iteraction > result)
                result = iteraction;
        
        return result;
    }

    /**
     * Obtém a posição do maior número no array.
     *
     * @param numeros Os números.
     * @return Retorna  a posição do maior número no array numeros. Se o array tiver tamanho zero
     * então retorna -1.
     */
    public int retornePosicaoDoMaiorNumero(int[] numbers) {
        int result;
        
        if(numbers.length == 0)
            result = -1;
        else
        {
            result = 0;
            int temp = numbers[0];
            
            for(int i = 0; i < numbers.length; i++)
            {
                if(numbers[i] > temp)
                {
                    temp = numbers[i];
                    result = i;
                }
            }    
        }
        
        return result;
    }

    /**
     * Calcula quantos números no array são maiores que um número limite.
     *
     * @param numeros Os números.
     * @param limite O limite.
     * @return Retorna a quantidade de números acima de limite.
     */
    public int retorneQuantidadeAcimaDeLimite(int[] numbers, int limite) {
        int result = 0;
        
        for(int iteraction : numbers)
            if (iteraction > limite)
                result++;
        
        return result;
    }

    /**
     * Calcula a média simples dos números. Considere que o array sempre tem pelo menos um número.
     *
     * @param numeros Os números.
     * @return Retorna a média dos números.
     */
    public float retorneMedia(int[] numbers) {
        float media = 0;
        
        for(int iteraction : numbers)
            media += iteraction;
        
        return media / numbers.length;
    }

    /**
     * Calcula quantos números estão dentro de um intervalo. Exemplo: se o intervalo for [10,40] então estarão no intervalo
     * os números que forem maiores ou iguais a 10 e menores ou iguais a 40.
     *
     * @param numeros Os números.
     * @param limiteInferior O limite inferior do intervalo.
     * @param limiteSuperior O limite superior do intervalo.
     * @return Retorna a quantidade de números dentro do intervalo.
     */
    public int retorneQuantosNoIntervalo(int[] numbers, int inferiorBound, int superiorBound) {
        int result = 0;
        
        for(int iteraction : numbers)
            if(iteraction >= inferiorBound && iteraction <= superiorBound)
                result++;
        
        return result;
    }

    /**
     * Multiplica cada número do array por um determinado fator.
     *
     * @param numeros Os números.
     * @param fator O fator.
     */
    public void multipliquePorFator(int[] numbers, int scalar) {
        for(int i = 0; i < numbers.length; i++)
            numbers[i] = scalar*numbers[i];
    }

    /**
     * Obtém uma cópia do array contendo os números multiplicados por um determinado fator. Exemplo:
     * se o array for [8,3,1] e o fator for 3 então retorna o novo array [24,9,3].
     *
     * @param numeros Os números.
     * @param fator O fator.
     * @return Retorna um array contendo os números multiplicados pelo fator.
     */
    public int[] retorneMultiplicadoPorFator(int[] numbers, int scalar) {
        int[] result = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++)
            result[i] = scalar*numbers[i];
        
        return result;
    }

    /**
     * Obtém uma cópia dos n primeiros números do array. Se n for maior que a quantidade
     * de números do array então obtém uma cópia de todos os números do array.
     *
     * @param numeros Os números.
     * @param n A quantidade de números a serem copiados.
     * @return Retorna a cópia dos n primeiros números.
     */
    public int[] copieNPrimeiros(int[] numbers, int n) {
        int[] result;
        
        if(n > numbers.length)
        {
            result = new int[numbers.length];
            
            for(int i = 0; i < numbers.length; i++)
                result[i] = numbers[i];
        }   
        else
        {
            result = new int[n];
            
            for(int i = 0; i < n; i++)
                result[i] = numbers[i];
        }
        
        return result;
    }

    /**
     * Obtém uma cópia dos números do array.
     *
     * @param numeros Os números
     * @return Retorna uma cópia dos números.
     */
    public int[] retorneCopia(int[] numbers) {
        return this.copieNPrimeiros(numbers, numbers.length);
    }

    /**
     * Obtém todos os números do array que estão dentro de um intervalo.
     *
     * @param numeros Os números.
     * @param limiteInferior O limite inferior do intervalo.
     * @param limiteSuperior O limite superior do intervalo.
     * @return Retorna os números que estão no intervalo.
     */
    public int[] retorneNumerosNoIntervalo(int[] numbers, int inferiorBound, int superiorBound) {
        int[] result = new int[retorneQuantosNoIntervalo(numbers, inferiorBound, superiorBound)];
        int j = 0;
        
        for(int i = 0; i < numbers.length; i++)
            if(numbers[i] >= inferiorBound && numbers[i] <= superiorBound)
            {
                result[j] = numbers[i];
                j++;
            }
            
        return result;
    }

    /**
     * Une dois arrays. Exemplo: se os arrays forem [5,2] e [9,1,2] então o método retorna [5,2,9,1,2].
     *
     * @param a1 O primeiro array.
     * @param a2 O segundo array.
     * @return Retorna um array contendo os números dos arrays a1 e a2.
     */
    public int[] unaArrays(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        
        for(int i = 0; i < a1.length; i++)
            result[i] = a1[i];
        for(int i = 0; i < a2.length; i++)
            result[a1.length + i] = a2[i];
        
        return result;
    }

    /**
     * Obtém os números pares contidos no array.
     *
     * @param numeros Os números.
     * @return Retorna os números pares existentes no array numeros.
     */
    public int[] retornePares(int[] numbers) {
        int[] result;
        int temp = 0;
        
        for(int i = 0; i < numbers.length; i++)
            if(numbers[i] % 2 == 0)
                temp++;
                
        result = new int[temp];
        temp = 0;
        
        for(int i = 0; i < numbers.length; i++)
            if(numbers[i] % 2 == 0)
            {
                result[temp] = numbers[i];
                temp++;
            }
        
        return result;
    }

    /**
     * Obtém um array contendo duas ocorrências de cada número. Exemplo: se o array for formado pelos
     * números [7,2,6] então o método retorna o array [7,7,2,2,6,6].
     *
     * @param numeros Os números.
     * @return Retorna o array contendo duas ocorrências de cada número existente em numeros.
     */
    public int[] dupliqueArray(int[] numbers) {
        int[] result = new int[2*numbers.length];
        
        for(int i = 0; i <numbers.length; i++)
        {
            result[2*i] = numbers[i];
            result[2*i + 1] = numbers[i];
        }
        
        return result;
    }


    /**
     * Verifica se o array possui pelo menos um número par.
     *
     * @param numeros Os números.
     * @return Retorna true se o array possui pelo menos um número par ou false caso contrário.
     */
    public boolean possuiNumeroPar(int[] numbers) {
        boolean result = false;
        int i = 0;
        
        while(i != numbers.length && result == false)
        {
            if(numbers[i] % 2 == 0)
                result = true;
            i++;
        }    
        return result;
    }

    /**
     * Obtém a posição da primeira ocorrência de um número dentro de um array. Se o número não estiver no
     * array então o método retorna a posição -1. Exemplo: se o array for [7,3,2,3,8] e o número for 3 então
     * o método retorna 1. Se o número for 4 então o método retorna -1.
     *
     * @param numeros Os números.
     * @param n Um número.
     * @return Retorna a posição da primeira ocorrência do número n no array numeros.
     */
    public int retornePrimeiraPosicaoDeNumero(int[] numbers, int n) {
        int result = -1, i = 0;
        
        while(i < numbers.length && result == -1)
        {
            if(numbers[i] == n)
                result = i;
            i++;
        }
        
        return result;
    }

    /**
     * Obtém as posições em que um número aparece dentro de um array. Exemplo: para o array [9,12,6,9] o número 9 aparece nas posições 0 e 3.
     *
     * @param numeros Os números.
     * @param n O número.
     * @return As posições de n no array numeros.
     */
    public int[] retornePosicoesDeNumero(int[] numbers, int n) {
        int[] result = new int[retorneQuantasOcorrencias(numbers, n)];
        int j = 0;
        
        for(int i = 0; i < numbers.length; i++)
            if(numbers[i] == n)
            {
                result[j] = i;
                j++;
            }
        
        return result;
    }

    /**
     * Verifica se o array não possui números repetidos.
     *
     * @param numeros Os números.
     * @return Retorna true se o array numeros não possui números repetidos ou false caso contrário.
     */
    public boolean semRepeticoes(int[] numbers) {
        boolean result = true;
        
        if(numbers.length >= 2)
            for(int i = 0; i < numbers.length; i++)
                for(int j = i+1; j < numbers.length; j++)
                    if(numbers[i] == numbers[j])
                    {
                        result = false;
                        j = numbers.length;
                        i = numbers.length;
                    }
            
        return result;
    }

    
    /**
     * Obtém um array sem ocorrências de um determinado número. Exemplo: se o array for [8,2,3,2] e o número for 2 então retorna [8,3].
     *
     * @param numeros Os números.
     * @param n Um número.
     * @return Retorna um array onde n foi removido do array numeros.
     */
    public int[] retorneSemOcorrencias(int[] numbers, int n) {
        int[] result = new int[numbers.length - retorneQuantasOcorrencias(numbers, n)];
        int j = 0;
        
        for(int i = 0; i < numbers.length; i++)
            if(numbers[i] != n)
            {
                result[j] = numbers[i];
                j++;
            }
            
        return result;
    }

}
