package es.dws.JVBt06e04.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.dws.JVBt06e04.models.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
