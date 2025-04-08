//package com.example.spring_boot_mini_project.config.ldap;



//public class InMemoryLdapServer {

//    private static final String BASE_DN = "dc=example,dc=com";
//    private static LdapServer ldapServer;
//    private static DirectoryService directoryService;
//
//    public static void startLdapServer() throws LdapException {
//        directoryService = new InMemoryDirectoryServiceFactory().getDirectoryService();
//        directoryService.setWorkingDirectory("target/ldap");
//
//        LdapServerConfig ldapServerConfig = new LdapServerConfig();
//        ldapServerConfig.setPort(10389); // Default LDAP port for testing
//        ldapServerConfig.setHost("localhost");
//
//        ldapServer = new LdapServer();
//        ldapServer.setConfiguration(ldapServerConfig);
//        ldapServer.setDirectoryService(directoryService);
//        ldapServer.start();
//
//        System.out.println("LDAP Server started on localhost:10389");
//    }
//
//    public static void stopLdapServer() throws LdapException {
//        if (ldapServer != null) {
//            ldapServer.stop();
//            System.out.println("LDAP Server stopped.");
//        }
//    }

//    public static void main(String[] args) throws LdapException {
//        startLdapServer();
//
//        // Add test data here (optional)
//        // e.g., add a user to the in-memory server
//
//        stopLdapServer();
//    }
//}
