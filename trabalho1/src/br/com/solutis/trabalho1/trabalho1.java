package br.com.solutis.trabalho1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


public class trabalho1 {

	public static void main(String[] args) {
		
		/*
		 * Considerando a lista abaixo execute as seguintes operações usando as features do Java 8+
		   não utilize: for/while/if
		 */

		
		List<Integer> numbers = Arrays.asList(1, 5, 8, 7, 4, 1, 6, 3, 2, 1, 8, 5, 7, 4);
		
		
		
		

		System.out.println("1. imprima todos os itens da lista no console\n");
	
			numbers.forEach(System.out::println);

		System.out.println("----------------------------------------");
		
		
		
		
		
		
		System.out.println("2. imprima os números distintos em ordem crescente\n");
		
			numbers.stream().distinct().sorted().forEach(System.out::println);
		
		System.out.println("----------------------------------------");
		
		
		
		
		
		
		System.out.println("3. imprima os números impares  e distintos em ordem decrescente\n");
		
			numbers.stream().distinct().filter(n -> n%2!=0).sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		System.out.println("----------------------------------------");	

		
		
		
		
		
		System.out.println("4. imprima a soma dos números ignorando os 3 primeiros\n");
		
			System.out.println("Total (ignorando os 3 primeiros items): " +numbers.stream().skip(3).mapToInt(numbers::get).sum());
	
		System.out.println("----------------------------------------");	
		
		
		
		
		
		
		System.out.println("5. imprima cada número da lista multiplicado por 2\n");
		
			numbers.forEach(c -> System.out.println(c * 2));
		
		System.out.println("----------------------------------------");	
		
		
		
		
			
		
		 /* 
		  * Neste exercício, fiquei na dúvida por conta de não poder usar "if", 
		    sendo que, no método de agrupamento, tem um de forma resumida.
		    Por este motivo fiz um com groupingBy normal com o if compacto, 
		    e outro sem if nenhum.
		 */
		
		System.out.println("6. imprima de forma agrupada os números pares e impares ( ambos os grupos apenas números distintos)\n");
		
		
		    System.out.println("Com if Incluso: \n");
		    
				numbers.stream().distinct().sorted().collect(Collectors.groupingBy(x -> x % 2 == 0 ? "Numeros pares" : "Numeros impares")).forEach((k, n) -> System.out.println("\n"+ k +": " + n));
		
		
			System.out.println("\n\nSem if Incluso: \n");
			
			    Map<Boolean, List<Integer>> grupos = numbers.stream().distinct().sorted().collect(Collectors.partitioningBy(x -> x % 2 == 0));
				System.out.println("\nNumeros impares: " + grupos.get(false) +"\n");
				System.out.println("Numeros pares: " + grupos.get(true) +"\n");

				
		System.out.println("----------------------------------------");		
		
		
		
		
		
		
		
		
		System.out.println("7. imprima o maior número da lista, se não houver lance uma java.util.NoSuchElementException\n");
			
			System.out.println("O maior valor é: " + numbers.stream().mapToInt(n -> n).max().orElseThrow(NoSuchElementException::new));
		
		System.out.println("----------------------------------------");		
		
		
		
		
		
		
		
		System.out.println("8. imprima apenas os 3 primeiros números da lista\n");
		
			numbers.stream().limit(3).forEach(System.out::println);
			
		System.out.println("----------------------------------------");	
		
		
		
		
		
		
		
		System.out.println("9. imprima a média dos números da lista, se não for possível calcular a média imprima Double.NaN\n");
		
			System.out.println(numbers.stream().mapToInt(n -> n).average().orElse(Double.NaN));
			
		System.out.println("----------------------------------------");		
			
		
		
		
		
		
		
		
		System.out.println("10. imprima a quantidade de elementos da lista, a soma de seus elementos, a média e o valor máximo\n");
		
			System.out.println("\nQuantidade de elementos: "+ numbers.size() 
							 + "\nSoma de elementos da lista: " + numbers.stream().mapToInt(numbers::get).sum() 
							 + "\nMedia: " + numbers.stream().mapToInt(n -> n).average().orElse(Double.NaN)
							 + "\nValorMaximo: " + numbers.stream().mapToInt(n -> n).max().orElseThrow(NoSuchElementException::new)
							 + "\n");
		
		System.out.println("----------------------------------------");	
		
		
		
		
		
		
		
		System.out.println("11. imprima a data de hoje, somando a quantidade de dias indicadas por cada elemento distinto da lista em ordem crescente\n");
			
			numbers.stream().distinct().sorted().forEach(n -> System.out.println(LocalDate.now().plusDays(n).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
			
		System.out.println("----------------------------------------");
			
	}

}
