package com.mx.Receptor.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.Receptor.DTOs.ClienteDTO;
import com.mx.Receptor.Entity.Beneficiario;
import com.mx.Receptor.Entity.Cliente;
import com.mx.Receptor.Entity.Contacto;
import com.mx.Receptor.Entity.Contrato;
import com.mx.Receptor.Entity.Documentacion;
import com.mx.Receptor.Entity.Domicilio;
import com.mx.Receptor.Entity.DomicilioBeneficiario;
import com.mx.Receptor.Entity.Producto;
import com.mx.Receptor.Repository.ClienteRepository;
import com.mx.Receptor.Repository.ContactoRepository;
import com.mx.Receptor.Repository.ContratoRepository;
import com.mx.Receptor.Repository.DocumentacionRepository;
import com.mx.Receptor.Repository.ProductoRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContactoRepository contactoRepository;

    @Autowired
    private DocumentacionRepository documentacionRepository;

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Transactional
    public Cliente procesarCliente(ClienteDTO dto) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // VALIDACIONES
        if (clienteRepository.existsByCurp(dto.getCurp())) {
            throw new IllegalArgumentException("Ya existe un cliente con esta CURP");
        }
        if (contactoRepository.existsByTelefono(dto.getContacto().getTelefono())) {
            throw new IllegalArgumentException("Ya existe un contacto con este teléfono");
        }
        if (contactoRepository.existsByEmail(dto.getContacto().getEmail())) {
            throw new IllegalArgumentException("Ya existe un contacto con este email");
        }
        if (documentacionRepository.existsByNumeroIdentificacion(dto.getDocumentacion().getNumeroIdentificacion())) {
            throw new IllegalArgumentException("Ya existe un documento con este número de identificación");
        }
        if (dto.getContrato().getIdContrato() != null && contratoRepository.existsByIdContrato(dto.getContrato().getIdContrato())) {
            throw new IllegalArgumentException("Ya existe un contrato con este ID");
        }

     // Se crea la entidad Cliente a partir de los datos recibidos en el DTO
        Cliente cliente = clienteRepository.findById(dto.getIdClienteDigital())
                .orElse(new Cliente());

        cliente.setIdClienteDigital(dto.getIdClienteDigital());
        cliente.setNombre(dto.getNombre());
        cliente.setApellidoPaterno(dto.getApellidoPaterno());
        cliente.setApellidoMaterno(dto.getApellidoMaterno());
        cliente.setGenero(dto.getGenero());
        cliente.setFechaNacimiento(sdf.parse(dto.getFechaNacimiento()));
        cliente.setCurp(dto.getCurp());

     // Se construye la información de contacto y se relaciona con el cliente
        Contacto contacto = cliente.getContacto() != null ? cliente.getContacto() : new Contacto();
        contacto.setIdContacto(contacto.getIdContacto() != null ? contacto.getIdContacto() : UUID.randomUUID().toString());
        contacto.setTelefono(dto.getContacto().getTelefono());
        contacto.setEmail(dto.getContacto().getEmail());
        contacto.setCliente(cliente);
        cliente.setContacto(contacto);

     // Se arma el domicilio principal del cliente
        Domicilio domicilio = cliente.getDomicilio() != null ? cliente.getDomicilio() : new Domicilio();
        domicilio.setIdDomicilio(domicilio.getIdDomicilio() != null ? domicilio.getIdDomicilio() : UUID.randomUUID().toString());
        domicilio.setEntidadFederativa(dto.getDomicilio().getEntidadFederativa());
        domicilio.setMunicipio(dto.getDomicilio().getMunicipio());
        domicilio.setColonia(dto.getDomicilio().getColonia());
        domicilio.setCalle(dto.getDomicilio().getCalle());
        domicilio.setNumeroInterior(dto.getDomicilio().getNumeroInterior());
        domicilio.setNumeroExterior(dto.getDomicilio().getNumeroExterior());
        domicilio.setCodigoPostal(dto.getDomicilio().getCodigoPostal());
        domicilio.setPais(dto.getDomicilio().getPais());
        domicilio.setCliente(cliente);
        cliente.setDomicilio(domicilio);

     // Se registra la documentación oficial asociada al cliente
        Documentacion doc = cliente.getDocumentacion() != null ? cliente.getDocumentacion() : new Documentacion();
        doc.setIdDocumentacion(doc.getIdDocumentacion() != null ? doc.getIdDocumentacion() : UUID.randomUUID().toString());
        doc.setTipoIdentificacion(dto.getDocumentacion().getTipoIdentificacion());
        doc.setNumeroIdentificacion(dto.getDocumentacion().getNumeroIdentificacion());
        doc.setCliente(cliente);
        cliente.setDocumentacion(doc);

     // Se crea un beneficiario vinculado al cliente
        Beneficiario b = new Beneficiario();
        b.setIdBeneficiario(UUID.randomUUID().toString());
        b.setNombre(dto.getBeneficiario().getNombre());
        b.setApellidoPaterno(dto.getBeneficiario().getApellidoPaterno());
        b.setApellidoMaterno(dto.getBeneficiario().getApellidoMaterno());
        b.setFechaNacimiento(sdf.parse(dto.getBeneficiario().getFechaNacimiento()));
        b.setCliente(cliente);

     // Se define el domicilio del beneficiario
        DomicilioBeneficiario db = new DomicilioBeneficiario();
        db.setIdDomicilio(UUID.randomUUID().toString());
        db.setEntidadFederativa(dto.getBeneficiario().getDomicilio().getEntidadFederativa());
        db.setMunicipio(dto.getBeneficiario().getDomicilio().getMunicipio());
        db.setColonia(dto.getBeneficiario().getDomicilio().getColonia());
        db.setCalle(dto.getBeneficiario().getDomicilio().getCalle());
        db.setNumeroInterior(dto.getBeneficiario().getDomicilio().getNumeroInterior());
        db.setNumeroExterior(dto.getBeneficiario().getDomicilio().getNumeroExterior());
        db.setCodigoPostal(dto.getBeneficiario().getDomicilio().getCodigoPostal());
        db.setPais(dto.getBeneficiario().getDomicilio().getPais());
        db.setBeneficiario(b);
        b.setDomicilio(db);
        
     // Se añade el beneficiario a la lista del cliente
        cliente.setBeneficiarios(List.of(b));

     // Se crea el contrato asociado al cliente y se vincula con un producto
        Contrato c = new Contrato();
        c.setIdContrato(dto.getContrato().getIdContrato() != null ? dto.getContrato().getIdContrato() : UUID.randomUUID().toString());
        c.setFechaExpiracion(sdf.parse(dto.getContrato().getFechaExpiracion()));
        c.setCliente(cliente);

     // Se busca el producto por ID, si no existe se crea uno nuevo
        Producto producto = productoRepository.findById(dto.getIdProducto()).orElseGet(() -> {
            Producto p = new Producto();
            p.setIdProducto(dto.getIdProducto());
            return productoRepository.save(p);
        });
        
     // Se asocia el producto creado al contrato
        c.setProducto(producto);
     // Se asigna el contratos ) al cliente  
        cliente.setContratos(List.of(c));

     // se manda a guardar el cliente junto a todas sus entidades
        return clienteRepository.save(cliente);
    }
}
