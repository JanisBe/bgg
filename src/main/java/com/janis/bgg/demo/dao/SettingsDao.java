package com.janis.bgg.demo.dao;

import com.janis.bgg.demo.entity.Settings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingsDao extends JpaRepository<Settings, Long> {

}
