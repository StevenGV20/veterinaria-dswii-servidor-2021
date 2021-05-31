package com.veterinaria.servidor.service;

import java.util.List;
import java.util.Optional;

import com.veterinaria.servidor.entity.Especie;
import com.veterinaria.servidor.entity.Mascota;
public interface MascotaService {

	//ESPECIE
		public abstract List<Especie> listaEspecie();
		

		public abstract List<Mascota> listaMascota();
		public abstract List<Mascota> listaMascotaByCliente(int cliente);
		public abstract Mascota mantenerMascota(Mascota bean);
		public abstract Optional<Mascota> buscaMascotaPorId(int idmascota);
		public abstract void eliminaMascota(int id);

}
