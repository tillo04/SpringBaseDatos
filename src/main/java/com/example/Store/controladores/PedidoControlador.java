package com.example.Store.controladores;

import com.example.Store.modelos.Pedido;
import com.example.Store.modelos.Usuario;
import com.example.Store.servicios.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("storeapi/v1/pedido")
public class PedidoControlador {
    @Autowired
    PedidoServicio pedidoServicio;

    @PostMapping
    public ResponseEntity<?> guardarPedido(@RequestBody Pedido datosPedido){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(pedidoServicio.guardarPedido(datosPedido));

        }catch (Exception error){
            Map<String, Object> errorDetails=new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message", error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);
        }
    }

    @GetMapping
    public ResponseEntity<?> consultarTodosPedidos(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(pedidoServicio.buscarTodosPedido());

        }catch (Exception error){
            Map<String, Object>errorDetails=new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message", error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);

        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> buscarPedidoPorId(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(pedidoServicio.consultarPedidoId(id));

        }catch (Exception error){
            Map<String, Object>errorDetails=new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message", error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);

        }
    }

}
