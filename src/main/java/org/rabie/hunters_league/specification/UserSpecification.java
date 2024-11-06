package org.rabie.hunters_league.specification;

import org.rabie.hunters_league.domain.User;
import org.rabie.hunters_league.service.dto.UserSearchDto;
import org.springframework.data.domain.Sort;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecification {

    public static Specification<User> getUsersByCriteria(UserSearchDto searchDto) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (searchDto.getId() != null && !searchDto.getId().toString().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("id"), searchDto.getId()));
            }

            if (searchDto.getEmail() != null && !searchDto.getEmail().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("email"), searchDto.getEmail()));
            }

            if (searchDto.getUsername() != null && !searchDto.getUsername().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("username"), searchDto.getUsername()));
            }

            if (searchDto.getCin() != null && !searchDto.getCin().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("cin"), searchDto.getCin()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}