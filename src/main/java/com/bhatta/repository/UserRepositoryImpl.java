package com.bhatta.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bhatta.domain.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

  private final EntityManager entityManager;

  @Autowired
  public UserRepositoryImpl(final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public void storeUser(final UserDetails userDetails) {
    entityManager.persist(userDetails);
  }

  @Override
  public UserDetails getUser(final String phoneNumber) {
    String query = "Select u from UserDetails u where u.phoneNumber= :pNumber";

    TypedQuery<UserDetails> userTypedQuery = entityManager.createQuery(query, UserDetails.class);
    userTypedQuery.setParameter("pNumber", phoneNumber);

    List<UserDetails> list = userTypedQuery.getResultList();

    if (list.isEmpty()) {
      return null;
    }

    return list.get(0);
  }
}
