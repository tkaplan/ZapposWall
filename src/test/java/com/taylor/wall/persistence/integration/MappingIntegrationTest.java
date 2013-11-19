package com.taylor.wall.persistence.integration;

import com.taylor.wall.config.JPAConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static com.taylor.wall.persistence.domain.fixture.JPAAssertions.assertTableExists;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfiguration.class})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class MappingIntegrationTest {

  @Autowired
  EntityManager manager;

  @Test
  public void thatItemCustomMappingWorks() throws Exception {
    assertTableExists(manager, "POST");
    assertTableExists(manager, "USER");
    assertTableExists(manager, "WALL");
  }

}
