package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionProducto;
import com.example.Store.modelos.Producto;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {
    @Autowired
    ValidacionProducto validacionProducto;
    @Autowired
    ProductoRepositorio productoRepositorio;

    public Producto guardarProducto(Producto datosProducto) throws Exception{
        try{
            if (!validacionProducto.validarNombre(datosProducto.getNombreProducto())){
                throw new Exception("Nombre invalido");
            }
            if (!validacionProducto.validarDescripcion(datosProducto.getDescripcion())){
                throw new Exception("Descripcion invalida");
            }
            if (!validacionProducto.validarTalla(datosProducto.getTalla())){
                throw new Exception("Talla invalida");
            }
            if (!validacionProducto.validarReferencia(datosProducto.getReferencia())){
                throw new Exception("Referencia invalida");
            }
            if (!validacionProducto.validarFotografia(datosProducto.getFotografia())){
                throw new Exception("Fotografia invalida");
            }
            if (!validacionProducto.validarCantidadBodega(datosProducto.getCantidadBodega())){
                throw new Exception("Cantidad bodega invalida");
            }
            if (!validacionProducto.validarPrecioUnitario(datosProducto.getPrecioUnitario())){
                throw new Exception("Precio invalido");
            }

            return productoRepositorio.save(datosProducto);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Producto  consultarProductoId(Integer idProducto)throws Exception{
        try {
            if (productoRepositorio.findById(idProducto).isPresent()){
                return productoRepositorio.findById(idProducto).get();
            }else {
                throw new Exception("Producto no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Producto> buscarTodosProducto() throws Exception{
        try {
            return productoRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public Producto  editarProducto(){
        return null;
    }
    public boolean eliminarProducto(){
        return true;
    }

}
