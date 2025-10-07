package com.mx.Responsables.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.mx.Responsables.DTOs.ResponsableResponseDTO;
import com.mx.Responsables.DTOs.VeterinariasDTO;
import com.mx.Responsables.Entity.Responsables;
import com.mx.Responsables.FeignClient.VeterinariaFeign;
import com.mx.Responsables.Repository.IResponsableRepository;
@Service
public class ResponsableServiceImp implements IResponsableService{
	
	@Autowired
	private IResponsableRepository dao;
	
	@Autowired
    private VeterinariaFeign veterinariaFC;

	@Override
	public void guardar(Responsables responsable) {
		
		dao.save(responsable);
	}

	@Override
	public void editar(Responsables responsable) {
		
		dao.save(responsable);
	}

	@Override
	public void eliminar(int idResponsable) {
		
		dao.deleteById(idResponsable);
	}

	@Override
	public Responsables buscar(int idResponsable) {
		
		return dao.findById(idResponsable).orElse(null);
	}

	@Override
	public List<Responsables> listar() {
		return dao.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
	}
	
	public List<ResponsableResponseDTO> listarTodasResponsables() {

        List<Responsables> responsables = dao.findAll();

        return responsables.stream().map(m -> {
        	ResponsableResponseDTO dto = new ResponsableResponseDTO();
            dto.setIdResponsable(m.getIdResponsable());
            dto.setNombre(m.getNombre());
            dto.setContacto(m.getContacto());

            try {
                VeterinariasDTO veterinaria = veterinariaFC.buscar(m.getVeterinariaId());
                dto.setVeterinariaId(veterinaria.getIdVeterinaria());
                dto.setNombreVeterinaria(veterinaria.getNombre());
            } catch (Exception e) {
                dto.setVeterinariaId(m.getVeterinariaId());
                dto.setNombreVeterinaria("Veterinaria no encontrada");
            }
            return dto;
        }).collect(Collectors.toList());
    }

}
