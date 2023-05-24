package com.example.lab6_sol.repository;

import com.example.lab6_sol.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findByRolid(int rol);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `registro_db`.`usuario` (`nombres`, `apellidos`, `dni`, `edad`, `correo`,  `password`, `activo`, `rolid`) " +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8);", nativeQuery = true)
    void crearStudent(String nombres, String apellidos, String dni, int edad, String correo, String password, int activo, int rolid);

    @Transactional
    @Modifying
    @Query(value = "update `registro_db`.`usuario` set nombres =?1, apellidos=?2,dni=?3,edad=?4,correo=?5,password=?6,activo=?7,rolid=?8 where id=?9 ",nativeQuery = true)
    void editStudent(String nombre, String apellidos, String dni, int edad, String correo, String password, int activo, int rolid, int id);
}
