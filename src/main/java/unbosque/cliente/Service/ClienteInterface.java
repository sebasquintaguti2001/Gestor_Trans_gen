package unbosque.cliente.Service;

import unbosque.cliente.DTO.ClienteDTO;

import java.util.List;


public interface ClienteInterface {


    ClienteDTO guardarCliente(ClienteDTO clienteDTO);


    List<ClienteDTO> listarClientes();


    ClienteDTO obtenerClientePorCedula(Long cedula);


    ClienteDTO actualizarCliente(ClienteDTO clienteDTO);


    void eliminarCliente(Long cedula);
}


