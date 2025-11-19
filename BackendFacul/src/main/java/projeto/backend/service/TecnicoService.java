package projeto.backend.service;

import org.springframework.stereotype.Service;
import projeto.backend.entity.Tecnico;
import projeto.backend.dto.TecnicoRequestDto;
import projeto.backend.mapper.TecnicoMapper;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TecnicoService {

    private final List<Tecnico> tecnicos = new ArrayList<>();
    private final TecnicoMapper mapper;
    private final Validator validator;

    public TecnicoService(TecnicoMapper mapper) {
        this.mapper = mapper;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    public Tecnico atualizarTecnico(Integer id, TecnicoRequestDto dto) {

        Tecnico tecnico = tecnicos.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Técnico não encontrado"));

        tecnico.setNome(dto.getNome());
        tecnico.setCpf(dto.getCpf().toString());
        tecnico.setEmail(dto.getEmail());
        tecnico.setSenha(dto.getSenha());

        return tecnico;
    }

    public void deletarTecnico(Integer id) {
        Tecnico tecnico = tecnicos.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Técnico não encontrado"));

        tecnicos.remove(tecnico);
    }



    public Tecnico criarTecnico(TecnicoRequestDto dto) {
        Set<ConstraintViolation<TecnicoRequestDto>> violations = validator.validate(dto);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<TecnicoRequestDto> v : violations) {
                sb.append(v.getMessage()).append("; ");
            }
            throw new RuntimeException("Erro de validação: " + sb.toString());
        }

        for (Tecnico t : tecnicos) {
            if (t.getCpf().equals(dto.getCpf())) {
                throw new RuntimeException("CPF já cadastrado");
            }
            if (t.getEmail().equals(dto.getEmail())) {
                throw new RuntimeException("Email já cadastrado");
            }
        }

        Tecnico tecnico = mapper.toEntity(dto);
        tecnico.setId(tecnicos.size() + 1);

        tecnicos.add(tecnico);
        return tecnico;
    }

    public List<Tecnico> listarTecnicos() {
        return tecnicos;
    }
}
