package me.dio.academia.digital.entity.form;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

  @NotBlank(message = "Campo não pode ser vazio")
  @Size(min = 3, max = 50, message = "'${validatedValue} precisa ter entre {min} e {max} caracteres'")
  private String nome;

  @NotBlank(message = "Campo não pode ser vazio")
  // @CPF(message = "${validatedValue} é inválido")
  private String cpf;

  @NotBlank(message = "Campo não pode ser vazio")
  @Size(min = 3, max = 50, message = "'${validatedValue} precisa ter entre {min} e {max} caracteres'")
  private String bairro;

  @NotNull(message = "Campo não pode ser vazio")
  @Past(message = "${validatedValue} é inválida")
  private LocalDate dataDeNascimento;
}
