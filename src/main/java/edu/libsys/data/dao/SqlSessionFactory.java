package edu.libsys.data.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

public class SqlSessionFactory {

    public static org.apache.ibatis.session.SqlSessionFactory MariaDBSqlSessionFactory;
    public static org.apache.ibatis.session.SqlSessionFactory Neo4jSqlSessionFactory;

    public static void main(String[] args) {
        SqlSession sqlSession = getNeo4jSqlSession();
        try {
            System.out.println(sqlSession.getConnection().isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回MariaDBSqlSession
     *
     * @return MariaDBSqlSession
     */
    public static SqlSession getMariaDBSqlSession() {
        if (MariaDBSqlSessionFactory == null) {
            try {
                DataSource dataSource = SqlSessionFactory.getMariaDBDataSource();
                TransactionFactory transactionFactory = new JdbcTransactionFactory();
                Environment MariaDBEnvironment = new Environment("mariadb", transactionFactory, dataSource);
                Configuration configuration = new Configuration(MariaDBEnvironment);
                configuration.addMappers("edu.libsys.data.mapper.mariadb");
                MariaDBSqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
            } catch (Exception e) {
                System.err.println("Build MariaDB SqlSessionFactory error.");
                e.printStackTrace();
            }
        }
        return MariaDBSqlSessionFactory.openSession();
    }

    /**
     * 返回Neo4jSqlSession
     *
     * @return Neo4jSqlSession.
     */
    public static SqlSession getNeo4jSqlSession() {
        if (Neo4jSqlSessionFactory == null) {
            try {
                DataSource dataSource = SqlSessionFactory.getNeo4jDataSource();
                TransactionFactory transactionFactory = new JdbcTransactionFactory();
                Environment Neo4jEnvironment = new Environment("neo4j", transactionFactory, dataSource);
                Configuration configuration = new Configuration(Neo4jEnvironment);
                configuration.addMappers("edu.libsys.data.mapper.neo4j");
                Neo4jSqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
            }catch (Exception e){
                System.err.println("Build Neo4j SqlSessionFactory error.");
                e.printStackTrace();
            }
        }
        return Neo4jSqlSessionFactory.openSession();
    }

    /**
     * 返回MariaDB的DataSource对象.
     *
     * @return a DataSource.
     */
    public static DataSource getMariaDBDataSource() {
        BasicDataSource mariadb = new BasicDataSource();
        mariadb.setDriverClassName("org.mariadb.jdbc.Driver");
        mariadb.setUrl("jdbc:mariadb://localhost:3306/LIBSYS");
        mariadb.setUsername("spark");
        mariadb.setPassword("123456a");
        return mariadb;
    }

    /**
     * Returns a MariaDB DataSource object.
     *
     * @return a DataSource.
     */
    public static DataSource getNeo4jDataSource() {
        BasicDataSource neo4j = new BasicDataSource();
        neo4j.setDriverClassName("org.neo4j.jdbc.bolt.BoltDriver");
        neo4j.setUrl("jdbc:neo4j:bolt://localhost:7687");
        neo4j.setUsername("neo4j");
        neo4j.setPassword("123456a");
        return neo4j;
    }
}
