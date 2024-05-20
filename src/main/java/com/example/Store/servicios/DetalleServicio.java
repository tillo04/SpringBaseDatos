package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionDetalle;
import com.example.Store.modelos.Detalle;
import com.example.Store.repositorios.DetalleRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleServicio {
    @Autowired
    ValidacionDetalle validacionDetalle;
    @Autowired
    DetalleRepositorio detalleRepositorio;

    public Detalle guardarDetalle(Detalle datosDetalle) throws Exception{
        try {
            if (!validacionDetalle.validarCostoTotal(datosDetalle.getCostoTotal())){
                throw new Exception("Costo invalido");
            }
            if (!validacionDetalle.validarCantidadProductos(datosDetalle.getCantidadProductos())){
                throw new Exception("Cantidad invalida");
            }

            return detalleRepositorio.save(datosDetalle);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Detalle consultarDetalleId(Integer idDetalle)throws Exception{
        try {
            if (detalleRepositorio.findById(idDetalle).isPresent()){
                return detalleRepositorio.findById(idDetalle).get();
            }else {
                throw new Exception("Usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Detalle> buscarTodosDetalle() throws Exception{
        try {
            return detalleRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public Detalle editarDetalle(){
        return null;
    }
    public boolean eliminarDetalle(){
        return true;
    }

}
