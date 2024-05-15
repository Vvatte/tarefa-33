package main.java.br.com.vvatte.dao;

import main.java.br.com.vvatte.domain.Carro;
import main.java.br.com.vvatte.domain.Marca;

public interface ICarroDao {
    Carro cadastrar(Carro carro);

    Carro buscarPorCodigoMarca(String codigo);

    Carro buscarPorMarca(Marca marca);
}
