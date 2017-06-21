package com.datastax.sample.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.KeyspaceMetadata;
import com.datastax.driver.core.Session;

public class SampleDao {

	private static Logger logger = LoggerFactory.getLogger(SampleDao.class);
	private Session session;

	private static String keyspaceName = "sample_keyspace";
	private static String testTable = keyspaceName + ".test";
	private List<KeyspaceMetadata> keyspaces;
	
	public SampleDao(String[] contactPoints) {

		Cluster cluster = Cluster.builder().addContactPoints(contactPoints).build();

		this.session = cluster.connect();
		this.keyspaces = cluster.getMetadata().getKeyspaces();
	}

	public List<KeyspaceMetadata> getKeyspaces() {
		return keyspaces;
	}

}
