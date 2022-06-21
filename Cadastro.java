package ACMEFinancas;

import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Cadastro {
	private ArrayList<Cobravel> cobraveis;

	public Cadastro(){
		cobraveis = new ArrayList<Cobravel>();
	}

	public boolean adiciona(Cobravel item) {
		for(Cobravel c : cobraveis){
			if(c.identificador == item.identificador){
				return false;
			}
		}
		cobraveis.add(item);
		return true;
	}

	public ArrayList<Cobravel> pesquisa(String nome) {
		ArrayList<Cobravel> array = new ArrayList<>();
		if(cobraveis.size()>0){
			for(Cobravel c: cobraveis){
				if(c.getNome().equalsIgnoreCase(nome)){
					array.add(c);
				}
			}
		}
		if(array.size()> 0) {
			return array;
		} else {
			return null;
		}
	}

	public ArrayList<Cobravel> pesquisa() {
		if(cobraveis.size()>0){
			return cobraveis;
		} else {
			return null;
		}
	}

	public double calculaImpostoItem(int identificador) {
		for(Cobravel c : cobraveis){
			if(c.identificador == identificador)
				return c.calculaImposto();
		}
		return -1;
	}

	public void salvaArquivoTexto(String nomeArquivo) {
		Path path = Paths.get(nomeArquivo + ".csv");
		try  {
			BufferedWriter bw = Files.newBufferedWriter(path, Charset.defaultCharset());
			PrintWriter pw = new PrintWriter(bw);
			for(Cobravel c : cobraveis) {
				pw.println(c.toCsv());
			}
			bw.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
