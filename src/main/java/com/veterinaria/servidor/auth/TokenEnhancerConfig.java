package com.veterinaria.servidor.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.veterinaria.servidor.entity.Usuario;
import com.veterinaria.servidor.service.UsuarioService;

@Component
public class TokenEnhancerConfig implements TokenEnhancer {
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario usuario = usuarioService.buscaUsuarioPorCorreo(authentication.getName());
		
		Map<String, Object> information = new HashMap<>();
		information.put("nombre", usuario.getNombre());
		information.put("apellido", usuario.getApellido());
		information.put("correo", usuario.getCorreo());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(information);
		return accessToken;
	}
	

}
