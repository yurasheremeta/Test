package ua.sombra.serviceImpl;

import java.sql.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.sombra.domain.AuthorDTO;
import ua.sombra.entity.AuthorEntity;
import ua.sombra.repository.AuthorRepository;
import ua.sombra.service.AuthorService;
import ua.sombra.service.utils.ObjectMapperUtils;

@Service
public class AuthorServiceImpl implements AuthorService {
	private final ObjectMapperUtils modelMapper;
	private final AuthorRepository authorRepository;


	@Autowired
	public AuthorServiceImpl(ObjectMapperUtils modelMapper, AuthorRepository authorRepository) {
		super();
		this.modelMapper = modelMapper;
		this.authorRepository = authorRepository;
	}

	@Override
	public void SaveAuthor(AuthorDTO dto) {
		AuthorEntity authorEntity = modelMapper.map(dto, AuthorEntity.class);
		authorRepository.save(authorEntity);

	}

	@Override
	public List<AuthorDTO> findAllAuthors() {
		List<AuthorEntity> authorEntities = authorRepository.findAll();
		List<AuthorDTO> authorDtos = modelMapper.mapAll(authorEntities, AuthorDTO.class);
		return authorDtos;
	}

	@Override
	public AuthorDTO findAuthorById(Long id) {
		AuthorEntity entity = authorRepository.findById(id).get();
		AuthorDTO dto = modelMapper.map(entity, AuthorDTO.class);
		return dto;
	}

	@Override
	public void updateAuthor(AuthorDTO dto) {
		authorRepository.save(modelMapper.map(dto, AuthorEntity.class));

	}

	@Override
	public void deleteAuthor(Long id) {
		authorRepository.deleteById(id);

	}

	@Override
	public List<AuthorDTO> findAuthorOlder55() {
		List<AuthorEntity> authorEntities = authorRepository.findAuthorOlder55();
		List<AuthorDTO> dtos = modelMapper.mapAll(authorEntities , AuthorDTO.class);
		return dtos;
	}

//	@Override
//	public List<AuthorDTO> findAuthorOlder55(Date born) {
//		List<AuthorEntity> authorEntities = authorRepository.findAuthorOlder55(born);
//		List<AuthorDTO> dtos = modelMapper.mapAll(authorEntities, AuthorDTO.class);
//		return dtos;
//	}
}
