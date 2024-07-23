[INFO] Running com.myapp.UserServiceTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.794 s - in com.myapp.UserServiceTest
[INFO] Running com.myapp.UserControllerTest
2024-07-23 12:13:11.355  INFO 2494 --- [           main] .b.t.a.w.s.WebMvcTestContextBootstrapper : Neither @ContextConfiguration nor @ContextHierarchy found for test class [com.myapp.UserControllerTest], using SpringBootContextLoader
2024-07-23 12:13:11.357  INFO 2494 --- [           main] o.s.t.c.support.AbstractContextLoader    : Could not detect default resource locations for test class [com.myapp.UserControllerTest]: no resource found for suffixes {-context.xml, Context.groovy}.
2024-07-23 12:13:11.360  INFO 2494 --- [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [com.myapp.UserControllerTest]: UserControllerTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2024-07-23 12:13:11.392  INFO 2494 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration com.myapp.Application for test class com.myapp.UserControllerTest
2024-07-23 12:13:11.393  INFO 2494 --- [           main] .b.t.a.w.s.WebMvcTestContextBootstrapper : Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener, org.springframework.boot.test.autoconfigure.webservices.client.MockWebServiceServerTestExecutionListener, org.springframework.test.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.event.ApplicationEventsTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.context.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener, org.springframework.test.context.event.EventPublishingTestExecutionListener]
2024-07-23 12:13:11.397  INFO 2494 --- [           main] .b.t.a.w.s.WebMvcTestContextBootstrapper : Using TestExecutionListeners: [org.springframework.test.context.web.ServletTestExecutionListener@68dbe225, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener@145ef9e8, org.springframework.test.context.event.ApplicationEventsTestExecutionListener@2e667e95, org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener@514b247b, org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener@66b62ebd, org.springframework.test.context.support.DirtiesContextTestExecutionListener@5440a3a, org.springframework.test.context.transaction.TransactionalTestExecutionListener@18cb4ed1, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener@10abd94f, org.springframework.test.context.event.EventPublishingTestExecutionListener@47bfde21, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener@628f0936, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener@20706e70, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener@6e5fba90, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener@57283fac, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener@4d745ac6, org.springframework.boot.test.autoconfigure.webservices.client.MockWebServiceServerTestExecutionListener@6e54bef6]

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.7.0)

2024-07-23 12:13:11.487  INFO 2494 --- [           main] com.myapp.UserControllerTest             : Starting UserControllerTest using Java 17.0.11 on 54c5c43782f7 with PID 2494 (started by root in /var/jenkins_home/workspace/tests)
2024-07-23 12:13:11.488  INFO 2494 --- [           main] com.myapp.UserControllerTest             : The following 1 profile is active: "test"
2024-07-23 12:13:13.435  INFO 2494 --- [           main] o.s.b.t.m.w.SpringBootMockServletContext : Initializing Spring TestDispatcherServlet ''
2024-07-23 12:13:13.437  INFO 2494 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Initializing Servlet ''
2024-07-23 12:13:13.439  INFO 2494 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Completed initialization in 2 ms
2024-07-23 12:13:13.493  INFO 2494 --- [           main] com.myapp.UserControllerTest             : Started UserControllerTest in 2.085 seconds (JVM running for 16.843)
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 2.564 s - in com.myapp.UserControllerTest
2024-07-23 12:13:13.822  INFO 2494 --- [ionShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
[INFO] 
[INFO] Results:
[INFO] 
[ERROR] Errors: 
[ERROR]   UserRepositoryIntegrationTest.whenFindByName_thenReturnUser:36 » Persistence o...
[ERROR]   UserServiceIntegrationTest.whenValidUserId_thenUserShouldBeFound » IllegalState
[INFO] 
[ERROR] Tests run: 4, Failures: 0, Errors: 2, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  26.076 s
[INFO] Finished at: 2024-07-23T12:13:14Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:2.22.2:test (default-test) on project backend: There are test failures.
[ERROR] 
[ERROR] Please refer to /var/jenkins_home/workspace/tests/target/surefire-reports for the individual test results.
[ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
[Pipeline] }
[Pipeline] // script
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
ERROR: script returned exit code 1
Finished: FAILURE
