package ua.sombra.serviceImpl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.sombra.entity.BookEntity;
import ua.sombra.service.BookService;
import ua.sombra.service.utils.ObjectMapperUtils;
import ua.sombra.domain.BookDTO;
import ua.sombra.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	private final BookRepository bookRepository;
	private final ObjectMapperUtils modelMapper;
	@Autowired
	public BookServiceImpl(BookRepository bookRepository, ObjectMapperUtils modelMapper) {
		super();
		this.bookRepository = bookRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public void create(BookDTO dto) {
		BookEntity bookEntity = modelMapper.map(dto, BookEntity.class);
		bookRepository.save(bookEntity);
	}

	@Override
	public List<BookDTO> findAllBooks() {
		List<BookEntity> bookEntities = bookRepository.findAll();
		List<BookDTO> dtos = modelMapper.mapAll(bookEntities, BookDTO.class);
		return dtos;
	}

	@Override
	public BookDTO findBookById(Long id) {
		BookEntity entity = bookRepository.findById(id).get();
		BookDTO dto = modelMapper.map(entity, BookDTO.class);
		return dto;
	}

	@Override
	public void updateBook(BookDTO dto) {
		bookRepository.save(modelMapper.map(dto , BookEntity.class));
	}

	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
		
	}

	@Override
	public BookDTO findCountByGenre(String genre) {
		BookEntity bookEntitie = bookRepository.findCountByGenre(genre);
		BookDTO dto = modelMapper.map(bookEntitie , BookDTO.class);
		return dto;
	}

	@Override
	public BookDTO findBook() {
		BookEntity bookEntity = bookRepository.findBook();
		BookDTO dto = modelMapper.map(bookEntity , BookDTO.class);
		return dto;
	}
}
