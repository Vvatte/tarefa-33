package main.java;

import main.java.br.com.vvatte.dao.*;
import main.java.br.com.vvatte.domain.Acessorio;
import main.java.br.com.vvatte.domain.Carro;
import main.java.br.com.vvatte.domain.Marca;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CarroTest {

    private ICarroDao carroDao;

    private IMarcaDao marcaDao;

    private IAcessorioDao acessorioDao;

    public CarroTest() {
        carroDao = new CarroDao();
        marcaDao = new MarcaDao();
        acessorioDao = new AcessorioDao();
    }

    @Test
    public void cadastrar() {
        Marca marca = criarMarca("A1");
        Acessorio acessorio = criarAcessorio("A1");

        Carro carro = new Carro();
        carro.setCodigo("A1");
        carro.setNome("Corolla");
        carro.setCor("Preto");
        carro.setValor(120000d);
        carro.setMarca(marca);
        carro.setAcessorio(acessorio);

        acessorio.setCarro(carro);
        carro = carroDao.cadastrar(carro);

        assertNotNull(carro);
        assertNotNull(carro.getId());

        Carro carroBD = carroDao.buscarPorCodigoMarca(carro.getCodigo());
        assertNotNull(carroBD);
        assertEquals(carro.getId(), carroBD.getId());

        Carro carroBDObj = carroDao.buscarPorMarca(marca);
        assertNotNull(carroBDObj);
        assertEquals(carro.getId(), carroBDObj.getId());

    }

    private Acessorio criarAcessorio(String codigo) {
        Acessorio acessorio = new Acessorio();
        acessorio.setCodigo(codigo);
        acessorio.setNome("Climatizador");
        acessorio.setDescricao("Aquecer/ Resfriar");

        return acessorioDao.cadastrar(acessorio);
    }

    private Marca criarMarca(String codigo) {
        Marca marca = new Marca();
        marca.setCodigo(codigo);
        marca.setNome("Toyota");
        marca.setPais("Japão");
        return marcaDao.cadastrar(marca);
    }
}
