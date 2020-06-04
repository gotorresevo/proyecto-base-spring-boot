# Configuracion de SONARQUBE en local
Proyecto de referencia para construir aplicaciones Spring Boot

### Prerequisitos:
###### - Maven
###### - Docker

### Docker
#### 1. Ubicate en la carpeta sonarqube
~~~
... proyecto-base-spring-boot>cd sonarqube
~~~
Resultado
~~~
... proyecto-base-spring-boot\sonarqube>
~~~
#### 2. Construye una imagen docker a partir del Dockerfile
~~~
... proyecto-base-spring-boot\sonarqube>docker build -t sonarqubelocal .
~~~
Resultado
~~~
Sending build context to Docker daemon  2.048kB
Step 1/2 : FROM gtorres04/sonarqube8:1.0.0
 ---> 7e4084ce58ad
Step 2/2 : EXPOSE 9000
 ---> Using cache
 ---> dfa9246607e2
Successfully built dfa9246607e2
Successfully tagged sonarqubelocal:latest
SECURITY WARNING: You are building a Docker image from Windows against a non-Windows Docker host. All files and directories added to build context will have '-rwxr-xr-x' permissions. It is recommended to double check and reset permissions for sensi
tive files and directories.
~~~
#### 3. Ejecuta la imagen creando un contenedor con Sonarqube (user/pass : admin/admin)
~~~
... proyecto-base-spring-boot\sonarqube>docker run -it -p 9000:9000 sonarqubelocal
~~~
Resultado
~~~
2020.06.03 09:23:07 INFO  app[][o.s.a.AppFileSystem] Cleaning or creating temp directory /opt/sonarqube/temp
2020.06.03 09:23:07 INFO  app[][o.s.a.es.EsSettings] Elasticsearch listening on /127.0.0.1:9001
2020.06.03 09:23:08 INFO  app[][o.s.a.ProcessLauncherImpl] Launch process[[key='es', ipcIndex=1, logFilenamePrefix=es]] from [/opt/sonarqube/elasticsearch]: /opt/sonarqube/elasticsearch/bin/elasticsearch
2020.06.03 09:23:08 INFO  app[][o.s.a.SchedulerImpl] Waiting for Elasticsearch to be up and running
OpenJDK 64-Bit Server VM warning: Option UseConcMarkSweepGC was deprecated in version 9.0 and will likely be removed in a future release.
2020.06.03 09:23:10 INFO  app[][o.e.p.PluginsService] no modules loaded
2020.06.03 09:23:10 INFO  app[][o.e.p.PluginsService] loaded plugin [org.elasticsearch.transport.Netty4Plugin]
2020.06.03 09:23:14 INFO  es[][o.e.e.NodeEnvironment] using [1] data paths, mounts [[/ (overlay)]], net usable_space [57.3gb], net total_space [62.7gb], types [overlay]
2020.06.03 09:23:14 INFO  es[][o.e.e.NodeEnvironment] heap size [495.3mb], compressed ordinary object pointers [true]
2020.06.03 09:23:14 INFO  es[][o.e.n.Node] node name [sonarqube], node ID [xv9W7zKWRG2e2aNhpaE1Pg]
2020.06.03 09:23:14 INFO  es[][o.e.n.Node] version[6.8.4], pid[31], build[default/tar/bca0c8d/2019-10-16T06:19:49.319352Z], OS[Linux/4.19.76-linuxkit/amd64], JVM[Oracle Corporation/OpenJDK 64-Bit Server VM/11.0.6/11.0.6+10]
2020.06.03 09:23:14 INFO  es[][o.e.n.Node] JVM arguments [-XX:+UseConcMarkSweepGC, -XX:CMSInitiatingOccupancyFraction=75, -XX:+UseCMSInitiatingOccupancyOnly, -Des.networkaddress.cache.ttl=60, -Des.networkaddress.cache.negative.ttl=10, -XX:+AlwaysPr
eTouch, -Xss1m, -Djava.awt.headless=true, -Dfile.encoding=UTF-8, -Djna.nosys=true, -XX:-OmitStackTraceInFastThrow, -Dio.netty.noUnsafe=true, -Dio.netty.noKeySetOptimization=true, -Dio.netty.recycler.maxCapacityPerThread=0, -Dlog4j.shutdownHookEnabl
ed=false, -Dlog4j2.disable.jmx=true, -Djava.io.tmpdir=/opt/sonarqube/temp, -XX:ErrorFile=../logs/es_hs_err_pid%p.log, -Xmx512m, -Xms512m, -XX:+HeapDumpOnOutOfMemoryError, -Des.path.home=/opt/sonarqube/elasticsearch, -Des.path.conf=/opt/sonarqube/te
mp/conf/es, -Des.distribution.flavor=default, -Des.distribution.type=tar]
2020.06.03 09:23:16 INFO  es[][o.e.p.PluginsService] loaded module [analysis-common]
2020.06.03 09:23:16 INFO  es[][o.e.p.PluginsService] loaded module [lang-painless]
2020.06.03 09:23:16 INFO  es[][o.e.p.PluginsService] loaded module [mapper-extras]
2020.06.03 09:23:16 INFO  es[][o.e.p.PluginsService] loaded module [parent-join]
2020.06.03 09:23:16 INFO  es[][o.e.p.PluginsService] loaded module [percolator]
2020.06.03 09:23:16 INFO  es[][o.e.p.PluginsService] loaded module [reindex]
2020.06.03 09:23:16 INFO  es[][o.e.p.PluginsService] loaded module [repository-url]
2020.06.03 09:23:16 INFO  es[][o.e.p.PluginsService] loaded module [transport-netty4]
2020.06.03 09:23:16 INFO  es[][o.e.p.PluginsService] no plugins loaded
2020.06.03 09:23:19 WARN  es[][o.e.d.c.s.Settings] [http.enabled] setting was deprecated in Elasticsearch and will be removed in a future release! See the breaking changes documentation for the next major version.
2020.06.03 09:23:21 INFO  es[][o.e.d.DiscoveryModule] using discovery type [zen] and host providers [settings]
2020.06.03 09:23:22 INFO  es[][o.e.n.Node] initialized
2020.06.03 09:23:22 INFO  es[][o.e.n.Node] starting ...
2020.06.03 09:23:22 INFO  es[][o.e.t.TransportService] publish_address {127.0.0.1:9001}, bound_addresses {127.0.0.1:9001}
2020.06.03 09:23:25 INFO  es[][o.e.c.s.MasterService] zen-disco-elected-as-master ([0] nodes joined), reason: new_master {sonarqube}{xv9W7zKWRG2e2aNhpaE1Pg}{_xZhN4-bQXmxnoCjQmyHyQ}{127.0.0.1}{127.0.0.1:9001}{rack_id=sonarqube}
2020.06.03 09:23:25 INFO  es[][o.e.c.s.ClusterApplierService] new_master {sonarqube}{xv9W7zKWRG2e2aNhpaE1Pg}{_xZhN4-bQXmxnoCjQmyHyQ}{127.0.0.1}{127.0.0.1:9001}{rack_id=sonarqube}, reason: apply cluster state (from master [master {sonarqube}{xv9W7zK
WRG2e2aNhpaE1Pg}{_xZhN4-bQXmxnoCjQmyHyQ}{127.0.0.1}{127.0.0.1:9001}{rack_id=sonarqube} committed version [1] source [zen-disco-elected-as-master ([0] nodes joined)]])
2020.06.03 09:23:25 INFO  es[][o.e.n.Node] started
2020.06.03 09:23:27 INFO  es[][o.e.g.GatewayService] recovered [7] indices into cluster_state
2020.06.03 09:23:38 INFO  es[][o.e.c.r.a.AllocationService] Cluster health status changed from [RED] to [GREEN] (reason: [shards started [[metadatas][0], [components][0]] ...]).
2020.06.03 09:23:38 INFO  app[][o.s.a.SchedulerImpl] Process[es] is up
2020.06.03 09:23:38 INFO  app[][o.s.a.ProcessLauncherImpl] Launch process[[key='web', ipcIndex=2, logFilenamePrefix=web]] from [/opt/sonarqube]: /usr/local/openjdk-11/bin/java -Djava.awt.headless=true -Dfile.encoding=UTF-8 -Djava.io.tmpdir=/opt/son
arqube/temp --add-opens=java.base/java.util=ALL-UNNAMED --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.io=ALL-UNNAMED --add-opens=java.rmi/sun.rmi.transport=ALL-UNNAMED -Xmx512m -Xms128m -XX:+HeapDumpOnOutOfMemoryError -Dhtt
p.nonProxyHosts=localhost|127.*|[::1] -cp ./lib/common/*:/opt/sonarqube/lib/jdbc/h2/h2-1.4.199.jar org.sonar.server.app.WebServer /opt/sonarqube/temp/sq-process10876079272192761249properties
2020.06.03 09:23:39 INFO  web[][o.s.p.ProcessEntryPoint] Starting web
2020.06.03 09:23:40 INFO  web[][o.a.t.u.n.NioSelectorPool] Using a shared selector for servlet write/read
2020.06.03 09:23:41 INFO  web[][o.e.p.PluginsService] no modules loaded
2020.06.03 09:23:41 INFO  web[][o.e.p.PluginsService] loaded plugin [org.elasticsearch.join.ParentJoinPlugin]
2020.06.03 09:23:41 INFO  web[][o.e.p.PluginsService] loaded plugin [org.elasticsearch.percolator.PercolatorPlugin]
2020.06.03 09:23:41 INFO  web[][o.e.p.PluginsService] loaded plugin [org.elasticsearch.transport.Netty4Plugin]
2020.06.03 09:23:43 INFO  web[][o.s.s.e.EsClientProvider] Connected to local Elasticsearch: [127.0.0.1:9001]
2020.06.03 09:23:43 INFO  web[][o.s.s.p.LogServerVersion] SonarQube Server / 8.2.0.32929 / ffde725e701a0acdc2bfac653743c4d91063cd45
2020.06.03 09:23:45 INFO  web[][o.s.s.p.d.EmbeddedDatabase] Starting embedded database on port 9092 with url jdbc:h2:tcp://127.0.0.1:9092/sonar
2020.06.03 09:23:45 INFO  web[][o.s.s.p.d.EmbeddedDatabase] Embedded database started. Data stored in: /opt/sonarqube/data
2020.06.03 09:23:45 INFO  web[][o.sonar.db.Database] Create JDBC data source for jdbc:h2:tcp://127.0.0.1:9092/sonar
2020.06.03 09:23:46 WARN  web[][o.s.db.dialect.H2] H2 database should be used for evaluation purpose only.
2020.06.03 09:23:48 INFO  web[][o.s.s.p.ServerFileSystemImpl] SonarQube home: /opt/sonarqube
2020.06.03 09:23:48 INFO  web[][o.s.s.u.SystemPasscodeImpl] System authentication by passcode is disabled
2020.06.03 09:23:48 INFO  web[][o.s.s.p.ServerPluginRepository] Deploy plugin Git / 1.9.1.1834 / 178899f274b2e5340ea158ab885608a8ea228b61
2020.06.03 09:23:48 INFO  web[][o.s.s.p.ServerPluginRepository] Deploy plugin JaCoCo / 1.0.2.475 / b79a4724f3a9af1051266b4f8ca0460977295ead
2020.06.03 09:23:48 INFO  web[][o.s.s.p.ServerPluginRepository] Deploy plugin SonarC# / 8.4.0.15306 / 55b44af00b78ca850c288d4e06cde496c240e14b
2020.06.03 09:23:48 INFO  web[][o.s.s.p.ServerPluginRepository] Deploy plugin SonarCSS / 1.2.0.1325 / 8dc9fe17b6230c20715d3b4cb34e0b6d02151afd
2020.06.03 09:23:48 INFO  web[][o.s.s.p.ServerPluginRepository] Deploy plugin SonarFlex / 2.5.1.1831 / a0c44437f6abb0feec76edd073f91fec64db2a6c
2020.06.03 09:23:48 INFO  web[][o.s.s.p.ServerPluginRepository] Deploy plugin SonarGo / 1.6.0.719 / edcc6a9e42fcdd30bb6f84a779c6cd7009ec72fd
2020.06.03 09:23:48 INFO  web[][o.s.s.p.ServerPluginRepository] Deploy plugin SonarHTML / 3.2.0.2082 / 997a51b39c4d0a5399c73a8fb729030a69eb392b
2020.06.03 09:23:48 INFO  web[][o.s.s.p.ServerPluginRepository] Deploy plugin SonarJS / 6.2.0.12043 / 8b9c1eb83d6ecfd2eda2cc3798e593900b6735fd
2020.06.03 09:23:48 INFO  web[][o.s.s.p.ServerPluginRepository] Deploy plugin SonarJava / 6.1.0.20866 / 057371cc3c87cb91535d78a247aa4337413e0087
2020.06.03 09:23:48 INFO  web[][o.s.s.p.ServerPluginRepository] Deploy plugin SonarKotlin / 1.5.0.315 / 4ff3a145a58f3f84f1b39846a205a129d742e993
2020.06.03 09:23:48 INFO  web[][o.s.s.p.ServerPluginRepository] Deploy plugin SonarPHP / 3.3.0.5166 / 88e11dffb965aeef9d5bdd6d8413f394d35fecba
2020.06.03 09:23:48 INFO  web[][o.s.s.p.ServerPluginRepository] Deploy plugin SonarPython / 2.5.0.5733 / a461002242ab2701d6fe4ba278dc62d95dd30ea2
2020.06.03 09:23:48 INFO  web[][o.s.s.p.ServerPluginRepository] Deploy plugin SonarRuby / 1.5.0.315 / 4ff3a145a58f3f84f1b39846a205a129d742e993
2020.06.03 09:23:48 INFO  web[][o.s.s.p.ServerPluginRepository] Deploy plugin SonarScala / 1.5.0.315 / 4ff3a145a58f3f84f1b39846a205a129d742e993
2020.06.03 09:23:48 INFO  web[][o.s.s.p.ServerPluginRepository] Deploy plugin SonarTS / 2.1.0.4359 / 268ba9581b700c4fb2bc194d4069d283da915213
2020.06.03 09:23:48 INFO  web[][o.s.s.p.ServerPluginRepository] Deploy plugin SonarVB / 8.4.0.15306 / 55b44af00b78ca850c288d4e06cde496c240e14b
2020.06.03 09:23:48 INFO  web[][o.s.s.p.ServerPluginRepository] Deploy plugin SonarXML / 2.0.1.2020 / c5b84004face582d56f110e24c29bf9c6a679e69
2020.06.03 09:23:48 INFO  web[][o.s.s.p.ServerPluginRepository] Deploy plugin Svn / 1.9.0.1295 / 942e075773975354e32691a60bfd968065703e04
2020.06.03 09:23:52 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.platform.web.WebServiceFilter@32442bbd [pattern=UrlPattern{inclusions=[/api/system/migrate_db.*, ...], exclusions=[/api/components/update_ke
y, ...]}]
2020.06.03 09:23:53 INFO  web[][o.s.s.a.EmbeddedTomcat] HTTP connector enabled on port 9000
2020.06.03 09:23:55 INFO  web[][o.s.s.p.UpdateCenterClient] Update center: https://update.sonarsource.org/update-center.properties (no proxy)
2020.06.03 09:23:56 INFO  web[][o.s.s.s.LogServerId] Server ID: BF41A1F2-AXEY7pH-yRfxHMYB3Wj0
2020.06.03 09:23:56 WARN  web[][o.s.s.a.LogOAuthWarning] For security reasons, OAuth authentication should use HTTPS. You should set the property 'Administration > Configuration > Server base URL' to a HTTPS URL.
2020.06.03 09:23:57 WARN  web[][o.s.a.s.w.WebService$Action] The response example is not set on action api/plugins/download
2020.06.03 09:23:57 WARN  web[][o.s.a.s.w.WebService$Action] The response example is not set on action api/permissions/search_templates
2020.06.03 09:23:57 INFO  web[][o.s.s.t.TelemetryDaemon] Sharing of SonarQube statistics is enabled.
2020.06.03 09:23:57 INFO  web[][o.s.s.n.NotificationDaemon] Notification service started (delay 60 sec.)
2020.06.03 09:23:57 INFO  web[][o.s.s.s.GeneratePluginIndex] Generate scanner plugin index
2020.06.03 09:23:57 INFO  web[][o.s.s.s.RegisterPlugins] Register plugins
2020.06.03 09:23:57 INFO  web[][o.s.s.s.RegisterMetrics] Register metrics
2020.06.03 09:23:57 INFO  web[][o.s.s.r.RegisterRules] Register rules
2020.06.03 09:24:06 INFO  web[][o.s.s.q.BuiltInQProfileRepositoryImpl] Load quality profiles
2020.06.03 09:24:06 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register quality profiles
2020.06.03 09:24:06 INFO  web[][o.s.s.q.RegisterQualityProfiles] Update profile css/Sonar way
2020.06.03 09:24:07 INFO  web[][o.s.s.q.RegisterQualityProfiles] Update profile scala/Sonar way
2020.06.03 09:24:07 INFO  web[][o.s.s.q.RegisterQualityProfiles] Update profile jsp/Sonar way
2020.06.03 09:24:07 INFO  web[][o.s.s.q.RegisterQualityProfiles] Update profile kotlin/Sonar way
2020.06.03 09:24:07 INFO  web[][o.s.s.q.RegisterQualityProfiles] Update profile go/Sonar way
2020.06.03 09:24:07 INFO  web[][o.s.s.q.RegisterQualityProfiles] Update profile js/Sonar way
2020.06.03 09:24:07 INFO  web[][o.s.s.q.RegisterQualityProfiles] Update profile js/Sonar way Recommended
2020.06.03 09:24:07 INFO  web[][o.s.s.q.RegisterQualityProfiles] Update profile py/Sonar way
2020.06.03 09:24:07 INFO  web[][o.s.s.q.RegisterQualityProfiles] Update profile ruby/Sonar way
2020.06.03 09:24:07 INFO  web[][o.s.s.q.RegisterQualityProfiles] Update profile cs/Sonar way
2020.06.03 09:24:07 INFO  web[][o.s.s.q.RegisterQualityProfiles] Update profile java/Sonar way
2020.06.03 09:24:07 INFO  web[][o.s.s.q.RegisterQualityProfiles] Update profile web/Sonar way
2020.06.03 09:24:08 INFO  web[][o.s.s.q.RegisterQualityProfiles] Update profile xml/Sonar way
2020.06.03 09:24:08 INFO  web[][o.s.s.q.RegisterQualityProfiles] Update profile flex/Sonar way
2020.06.03 09:24:08 INFO  web[][o.s.s.q.RegisterQualityProfiles] Update profile php/Sonar way
2020.06.03 09:24:08 INFO  web[][o.s.s.q.RegisterQualityProfiles] Update profile php/PSR-2
2020.06.03 09:24:08 INFO  web[][o.s.s.q.RegisterQualityProfiles] Update profile php/Drupal
2020.06.03 09:24:08 INFO  web[][o.s.s.q.RegisterQualityProfiles] Update profile vbnet/Sonar way
2020.06.03 09:24:08 INFO  web[][o.s.s.q.RegisterQualityProfiles] Update profile ts/Sonar way
2020.06.03 09:24:08 INFO  web[][o.s.s.q.RegisterQualityProfiles] Update profile ts/Sonar way recommended
2020.06.03 09:24:08 INFO  web[][o.s.s.s.RegisterPermissionTemplates] Register permission templates
2020.06.03 09:24:08 INFO  web[][o.s.s.s.RenameDeprecatedPropertyKeys] Rename deprecated property keys
2020.06.03 09:24:08 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.platform.web.WebServiceFilter@55a0be0d [pattern=UrlPattern{inclusions=[/api/issues/delete_comment.*, ...], exclusions=[/api/authentication/l
ogin.*, ...]}]
2020.06.03 09:24:08 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.platform.web.WebServiceReroutingFilter@365d102f [pattern=UrlPattern{inclusions=[/api/components/bulk_update_key, ...], exclusions=[]}]
2020.06.03 09:24:08 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.authentication.InitFilter@20e5bc3b [pattern=UrlPattern{inclusions=[/sessions/init/*], exclusions=[]}]
2020.06.03 09:24:08 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.authentication.OAuth2CallbackFilter@4e033b5e [pattern=UrlPattern{inclusions=[/oauth2/callback/*], exclusions=[]}]
2020.06.03 09:24:08 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.authentication.ws.LoginAction@49dcfe1c [pattern=UrlPattern{inclusions=[/api/authentication/login], exclusions=[]}]
2020.06.03 09:24:08 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.authentication.ws.LogoutAction@2a7c35b [pattern=UrlPattern{inclusions=[/api/authentication/logout], exclusions=[]}]
2020.06.03 09:24:08 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.authentication.ws.ValidateAction@44aed14f [pattern=UrlPattern{inclusions=[/api/authentication/validate], exclusions=[]}]
2020.06.03 09:24:08 INFO  web[][o.s.s.q.ProjectsInWarningDaemon] Counting number of projects in warning is not started as there are no projects in this situation.
2020.06.03 09:24:08 INFO  web[][o.s.s.p.p.PlatformLevelStartup] Running Community Edition
2020.06.03 09:24:08 INFO  web[][o.s.s.p.Platform] WebServer is operational
2020.06.03 09:24:08 INFO  app[][o.s.a.SchedulerImpl] Process[web] is up
2020.06.03 09:24:08 INFO  app[][o.s.a.ProcessLauncherImpl] Launch process[[key='ce', ipcIndex=3, logFilenamePrefix=ce]] from [/opt/sonarqube]: /usr/local/openjdk-11/bin/java -Djava.awt.headless=true -Dfile.encoding=UTF-8 -Djava.io.tmpdir=/opt/sonar
qube/temp --add-opens=java.base/java.util=ALL-UNNAMED -Xmx512m -Xms128m -XX:+HeapDumpOnOutOfMemoryError -Dhttp.nonProxyHosts=localhost|127.*|[::1] -cp ./lib/common/*:/opt/sonarqube/lib/jdbc/h2/h2-1.4.199.jar org.sonar.ce.app.CeServer /opt/sonarqube
/temp/sq-process2988581304910230504properties
2020.06.03 09:24:12 INFO  ce[][o.s.p.ProcessEntryPoint] Starting ce
2020.06.03 09:24:12 INFO  ce[][o.s.ce.app.CeServer] Compute Engine starting up...
2020.06.03 09:24:14 INFO  ce[][o.e.p.PluginsService] no modules loaded
2020.06.03 09:24:14 INFO  ce[][o.e.p.PluginsService] loaded plugin [org.elasticsearch.join.ParentJoinPlugin]
2020.06.03 09:24:14 INFO  ce[][o.e.p.PluginsService] loaded plugin [org.elasticsearch.percolator.PercolatorPlugin]
2020.06.03 09:24:14 INFO  ce[][o.e.p.PluginsService] loaded plugin [org.elasticsearch.transport.Netty4Plugin]
2020.06.03 09:24:20 INFO  ce[][o.s.s.e.EsClientProvider] Connected to local Elasticsearch: [127.0.0.1:9001]
2020.06.03 09:24:20 INFO  ce[][o.sonar.db.Database] Create JDBC data source for jdbc:h2:tcp://127.0.0.1:9092/sonar
2020.06.03 09:24:26 WARN  ce[][o.s.db.dialect.H2] H2 database should be used for evaluation purpose only.
2020.06.03 09:24:30 INFO  ce[][o.s.s.p.ServerFileSystemImpl] SonarQube home: /opt/sonarqube
2020.06.03 09:24:30 INFO  ce[][o.s.c.c.CePluginRepository] Load plugins
2020.06.03 09:24:45 INFO  ce[][o.s.c.c.ComputeEngineContainerImpl] Running Community edition
2020.06.03 09:24:45 INFO  ce[][o.s.ce.app.CeServer] Compute Engine is operational
2020.06.03 09:24:45 INFO  app[][o.s.a.SchedulerImpl] Process[ce] is up
2020.06.03 09:24:45 INFO  app[][o.s.a.SchedulerImpl] SonarQube is up
~~~
### Maven: Configuracion del setting.xml de Maven

#### 1. Agrega este profile
```xml
<profile>
  <id>sonar</id>
  <activation>
    <activeByDefault>true</activeByDefault>
  </activation>
  <properties>
    <!-- Optional URL to server. Default value is http://localhost:9000 -->
    <sonar.host.url>
      http://localhost:9000
    </sonar.host.url>
  </properties>
</profile>
```
#### 2. Agrega el pluginGroup
```xml
<pluginGroup>org.sonarsource.scanner.maven</pluginGroup>
```

### Validacion ante SONAR 
~~~
... proyecto-base-spring-boot>mvn clean verify install sonar:sonar
~~~
Resultado
~~~
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------------< com.evobanco:shopping >------------------------
[INFO] Building shoppingcart 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-clean-plugin:3.1.0:clean (default-clean) @ shopping ---
[INFO] Deleting C:\Users\gotorres_sel\Desktop\shoppingcart\target
[INFO]
[INFO] --- maven-resources-plugin:3.1.0:resources (default-resources) @ shopping ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ shopping ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 95 source files to C:\Users\gotorres_sel\Desktop\shoppingcart\target\classes
[INFO] /C:/Users/gotorres_sel/Desktop/shoppingcart/src/main/java/com/evobank/shopping/shared/infrastructure/bus/IQuery/QueryHandlersInformation.java: Some input files use unchecked or unsafe operations.
[INFO] /C:/Users/gotorres_sel/Desktop/shoppingcart/src/main/java/com/evobank/shopping/shared/infrastructure/bus/IQuery/QueryHandlersInformation.java: Recompile with -Xlint:unchecked for details.
[INFO]
[INFO] --- maven-resources-plugin:3.1.0:testResources (default-testResources) @ shopping ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\gotorres_sel\Desktop\shoppingcart\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ shopping ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 37 source files to C:\Users\gotorres_sel\Desktop\shoppingcart\target\test-classes
[INFO]
[INFO] --- jacoco-maven-plugin:0.8.3:prepare-agent (jacoco-initialize) @ shopping ---
[INFO] argLine set to -javaagent:C:\\Users\\gotorres_sel\\.m2\\repository\\org\\jacoco\\org.jacoco.agent\\0.8.3\\org.jacoco.agent-0.8.3-runtime.jar=destfile=C:\\Users\\gotorres_sel\\Desktop\\shoppingcart\\target\\coverage-reports\\jacoco-unit.exec,
append=true,excludes=*MethodAccess,output=file
[INFO]
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ shopping ---
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.evobank.shopping.controllers.restful.carts.AddProductToCartPutControllerTest
11:32:58.328 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating CacheAwareContextLoaderDelegate from class [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
11:32:58.366 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating BootstrapContext using constructor [public org.springframework.test.context.support.DefaultBootstrapContext(java.lang.Class,org.springframework.test.context.C
acheAwareContextLoaderDelegate)]
11:32:58.465 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating TestContextBootstrapper for test class [com.evobank.shopping.controllers.restful.carts.AddProductToCartPutControllerTest] from class [org.springframework.boo
t.test.context.SpringBootTestContextBootstrapper]
11:32:58.521 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Neither @ContextConfiguration nor @ContextHierarchy found for test class [com.evobank.shopping.controllers.restful.carts.AddProductToCartPutControll
erTest], using SpringBootContextLoader
11:32:58.535 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [com.evobank.shopping.controllers.restful.carts.AddProductToCartPutControllerTest]: class path resou
rce [com/evobank/shopping/controllers/restfull/carts/AddProductToCartPutControllerTest-context.xml] does not exist
11:32:58.536 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [com.evobank.shopping.controllers.restful.carts.AddProductToCartPutControllerTest]: class path resou
rce [com/evobank/shopping/controllers/restfull/carts/AddProductToCartPutControllerTestContext.groovy] does not exist
11:32:58.536 [main] INFO org.springframework.test.context.support.AbstractContextLoader - Could not detect default resource locations for test class [com.evobank.shopping.controllers.restful.carts.AddProductToCartPutControllerTest]: no resource fo
und for suffixes {-context.xml, Context.groovy}.
11:32:58.538 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils - Could not detect default configuration classes for test class [com.evobank.shopping.controllers.restful.carts.AddProductToCartPutControllerTest]
: AddProductToCartPutControllerTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
11:32:58.695 [main] DEBUG org.springframework.test.context.support.ActiveProfilesUtils - Could not find an 'annotation declaring class' for annotation type [org.springframework.test.context.ActiveProfiles] and class [com.evobank.shopping.controller
s.restfull.carts.AddProductToCartPutControllerTest]
11:32:58.905 [main] DEBUG org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider - Identified candidate component class: file [C:\Users\gotorres_sel\Desktop\shoppingcart\target\classes\com\evobank\shopping\ShoppingApplic
ation.class]
11:32:58.907 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Found @SpringBootConfiguration com.evobank.shopping.ShoppingApplication for test class com.evobank.shopping.controllers.restful.carts.AddProductToCa
rtPutControllerTest
11:32:59.173 [main] DEBUG org.springframework.boot.test.context.SpringBootTestContextBootstrapper - @TestExecutionListeners is not present for class [com.evobank.shopping.controllers.restful.carts.AddProductToCartPutControllerTest]: using defaults
.
11:32:59.175 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.boot.test.mock.mockito.MockitoTestEx
ecutionListener, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceS
erverResetTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener, org.springframework.tes
t.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.context
.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener, org.springframework.test.context.event.EventPublis
hingTestExecutionListener]
11:32:59.232 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Using TestExecutionListeners: [org.springframework.test.context.web.ServletTestExecutionListener@652b3733, org.springframework.test.context.support.D
irtiesContextBeforeModesTestExecutionListener@7b598d05, org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener@6cc8c13c, org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener@371cd2fc, org.s
pringframework.test.context.support.DirtiesContextTestExecutionListener@b32e983, org.springframework.test.context.transaction.TransactionalTestExecutionListener@3c346c45, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener@16df9bd
e, org.springframework.test.context.event.EventPublishingTestExecutionListener@478530cb, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener@5be7b749, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecution
Listener@44aeae34, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener@2ec5cc14, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener@40a8a26f, org
.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener@269308cc]
11:32:59.243 [main] DEBUG org.springframework.test.context.support.AbstractDirtiesContextTestExecutionListener - Before test class: context [DefaultTestContext@11cadb32 testClass = AddProductToCartPutControllerTest, testInstance = [null], testMetho
d = [null], testException = [null], mergedContextConfiguration = [WebMergedContextConfiguration@6d3ad37a testClass = AddProductToCartPutControllerTest, locations = '{}', classes = '{class com.evobank.shopping.ShoppingApplication}', contextInitializ
erClasses = '[]', activeProfiles = '{}', propertySourceLocations = '{}', propertySourceProperties = '{org.springframework.boot.test.context.SpringBootTestContextBootstrapper=true}', contextCustomizers = set[[ImportsContextCustomizer@26f5e45d key =
[org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcWebClientAutoConfiguration, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcWebDriverAu
toConfiguration, org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration, org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration, org.springframework.boot.test.autoconfigure.web.servlet
.MockMvcSecurityConfiguration]], org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@594d9f07, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@b5de58f, org.
springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.web.client.TestRestTemplateContextCustomizer@712c5463, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@4b3fa0b3
, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizerFactory$Customizer@45c9b3, org.springframework.boot.test.context.SpringBootTestArgs@1], resourceBasePath = 'src/main/webapp', contextLoader = 'org.springframework.b
oot.test.context.SpringBootContextLoader', parent = [null]], attributes = map['org.springframework.test.context.web.ServletTestExecutionListener.activateListener' -> true]], class annotated with @DirtiesContext [true] with mode [AFTER_EACH_TEST_MET
HOD].
11:32:59.321 [main] DEBUG org.springframework.test.context.support.TestPropertySourceUtils - Adding inlined properties to environment: {spring.jmx.enabled=false, org.springframework.boot.test.context.SpringBootTestContextBootstrapper=true, server.p
ort=-1}

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.7.RELEASE)

2020-06-03 11:33:00.055  INFO 14540 --- [           main] .c.r.c.AddProductToCartPutControllerTest : Starting AddProductToCartPutControllerTest on GFI10959 with PID 14540 (started by gotorres_sel in C:\Users\gotorres_sel\Desktop\shoppingcart)
2020-06-03 11:33:00.058  INFO 14540 --- [           main] .c.r.c.AddProductToCartPutControllerTest : No active profile set, falling back to default profiles: default
2020-06-03 11:33:04.319  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 236 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:04.423  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 88 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:05.753  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-06-03 11:33:06.506  INFO 14540 --- [           main] o.s.b.t.m.w.SpringBootMockServletContext : Initializing Spring TestDispatcherServlet ''
2020-06-03 11:33:06.507  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Initializing Servlet ''
2020-06-03 11:33:06.536  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Completed initialization in 29 ms
2020-06-03 11:33:06.611  INFO 14540 --- [           main] .c.r.c.AddProductToCartPutControllerTest : Started AddProductToCartPutControllerTest in 7.262 seconds (JVM running for 9.996)
2020-06-03 11:33:08.098  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.7.RELEASE)

2020-06-03 11:33:08.150  INFO 14540 --- [           main] .c.r.c.AddProductToCartPutControllerTest : Starting AddProductToCartPutControllerTest on GFI10959 with PID 14540 (started by gotorres_sel in C:\Users\gotorres_sel\Desktop\shoppingcart)
2020-06-03 11:33:08.151  INFO 14540 --- [           main] .c.r.c.AddProductToCartPutControllerTest : No active profile set, falling back to default profiles: default
2020-06-03 11:33:08.877  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 123 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:08.971  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 87 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:09.425  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-06-03 11:33:09.732  INFO 14540 --- [           main] o.s.b.t.m.w.SpringBootMockServletContext : Initializing Spring TestDispatcherServlet ''
2020-06-03 11:33:09.733  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Initializing Servlet ''
2020-06-03 11:33:09.748  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Completed initialization in 15 ms
2020-06-03 11:33:09.767  INFO 14540 --- [           main] .c.r.c.AddProductToCartPutControllerTest : Started AddProductToCartPutControllerTest in 1.661 seconds (JVM running for 13.153)
2020-06-03 11:33:09.800  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.7.RELEASE)

2020-06-03 11:33:09.868  INFO 14540 --- [           main] .c.r.c.AddProductToCartPutControllerTest : Starting AddProductToCartPutControllerTest on GFI10959 with PID 14540 (started by gotorres_sel in C:\Users\gotorres_sel\Desktop\shoppingcart)
2020-06-03 11:33:09.869  INFO 14540 --- [           main] .c.r.c.AddProductToCartPutControllerTest : No active profile set, falling back to default profiles: default
2020-06-03 11:33:10.720  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 131 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:10.859  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 128 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:11.349  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-06-03 11:33:11.711  INFO 14540 --- [           main] o.s.b.t.m.w.SpringBootMockServletContext : Initializing Spring TestDispatcherServlet ''
2020-06-03 11:33:11.713  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Initializing Servlet ''
2020-06-03 11:33:11.739  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Completed initialization in 26 ms
2020-06-03 11:33:11.762  INFO 14540 --- [           main] .c.r.c.AddProductToCartPutControllerTest : Started AddProductToCartPutControllerTest in 1.957 seconds (JVM running for 15.147)
2020-06-03 11:33:11.813  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 13.635 s - in com.evobank.shopping.controllers.restful.carts.AddProductToCartPutControllerTest
[INFO] Running com.evobank.shopping.controllers.restful.carts.CartPutControllerTest
2020-06-03 11:33:11.822  INFO 14540 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Neither @ContextConfiguration nor @ContextHierarchy found for test class [com.evobank.shopping.controllers.restful.carts.CartPutControllerTest], u
sing SpringBootContextLoader
2020-06-03 11:33:11.825  INFO 14540 --- [           main] o.s.t.c.support.AbstractContextLoader    : Could not detect default resource locations for test class [com.evobank.shopping.controllers.restful.carts.CartPutControllerTest]: no resource fou
nd for suffixes {-context.xml, Context.groovy}.
2020-06-03 11:33:11.827  INFO 14540 --- [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [com.evobank.shopping.controllers.restful.carts.CartPutControllerTest]: CartPutContr
ollerTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2020-06-03 11:33:11.833  INFO 14540 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration com.evobank.shopping.ShoppingApplication for test class com.evobank.shopping.controllers.restful.carts.CartPutContr
ollerTest
2020-06-03 11:33:11.839  INFO 14540 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.boot.test.mock.mockito.MockitoTest
ExecutionListener, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener, org.springframework.boot.test.autoconfigure.web.client.MockRestServic
eServerResetTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener, org.springframework.t
est.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.conte
xt.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener, org.springframework.test.context.event.EventPubl
ishingTestExecutionListener]
2020-06-03 11:33:11.840  INFO 14540 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Using TestExecutionListeners: [org.springframework.test.context.web.ServletTestExecutionListener@47560281, org.springframework.test.context.support
.DirtiesContextBeforeModesTestExecutionListener@59c4148c, org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener@4523432, org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener@9f2a220, org.s
pringframework.test.context.support.DirtiesContextTestExecutionListener@7e47eb95, org.springframework.test.context.transaction.TransactionalTestExecutionListener@7dee0a5, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener@12b8b7c
8, org.springframework.test.context.event.EventPublishingTestExecutionListener@ec7e41d, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener@4f1dbd13, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionL
istener@3f36b79d, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener@68674144, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener@59b1a759, org.
springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener@7b667c59]

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.7.RELEASE)

2020-06-03 11:33:11.989  INFO 14540 --- [           main] c.e.s.c.r.carts.CartPutControllerTest    : Starting CartPutControllerTest on GFI10959 with PID 14540 (started by gotorres_sel in C:\Users\gotorres_sel\Desktop\shoppingcart)
2020-06-03 11:33:11.991  INFO 14540 --- [           main] c.e.s.c.r.carts.CartPutControllerTest    : No active profile set, falling back to default profiles: default
2020-06-03 11:33:13.003  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 144 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:13.131  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 116 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:13.689  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-06-03 11:33:14.090  INFO 14540 --- [           main] o.s.b.t.m.w.SpringBootMockServletContext : Initializing Spring TestDispatcherServlet ''
2020-06-03 11:33:14.090  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Initializing Servlet ''
2020-06-03 11:33:14.111  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Completed initialization in 20 ms
2020-06-03 11:33:14.126  INFO 14540 --- [           main] c.e.s.c.r.carts.CartPutControllerTest    : Started CartPutControllerTest in 2.275 seconds (JVM running for 17.511)
2020-06-03 11:33:14.330  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.7.RELEASE)

2020-06-03 11:33:14.410  INFO 14540 --- [           main] c.e.s.c.r.carts.CartPutControllerTest    : Starting CartPutControllerTest on GFI10959 with PID 14540 (started by gotorres_sel in C:\Users\gotorres_sel\Desktop\shoppingcart)
2020-06-03 11:33:14.412  INFO 14540 --- [           main] c.e.s.c.r.carts.CartPutControllerTest    : No active profile set, falling back to default profiles: default
2020-06-03 11:33:15.344  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 139 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:15.484  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 127 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:15.938  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-06-03 11:33:16.268  INFO 14540 --- [           main] o.s.b.t.m.w.SpringBootMockServletContext : Initializing Spring TestDispatcherServlet ''
2020-06-03 11:33:16.268  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Initializing Servlet ''
2020-06-03 11:33:16.287  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Completed initialization in 18 ms
2020-06-03 11:33:16.297  INFO 14540 --- [           main] c.e.s.c.r.carts.CartPutControllerTest    : Started CartPutControllerTest in 1.956 seconds (JVM running for 19.683)
2020-06-03 11:33:16.321  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.431 s - in com.evobank.shopping.controllers.restful.carts.CartPutControllerTest
[INFO] Running com.evobank.shopping.controllers.restful.products.ProductPatchControllerTest
2020-06-03 11:33:16.326  INFO 14540 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Neither @ContextConfiguration nor @ContextHierarchy found for test class [com.evobank.shopping.controllers.restful.products.ProductPatchController
Test], using SpringBootContextLoader
2020-06-03 11:33:16.328  INFO 14540 --- [           main] o.s.t.c.support.AbstractContextLoader    : Could not detect default resource locations for test class [com.evobank.shopping.controllers.restful.products.ProductPatchControllerTest]: no reso
urce found for suffixes {-context.xml, Context.groovy}.
2020-06-03 11:33:16.328  INFO 14540 --- [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [com.evobank.shopping.controllers.restful.products.ProductPatchControllerTest]: Prod
uctPatchControllerTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2020-06-03 11:33:16.357  INFO 14540 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration com.evobank.shopping.ShoppingApplication for test class com.evobank.shopping.controllers.restful.products.ProductPa
tchControllerTest
2020-06-03 11:33:16.363  INFO 14540 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.boot.test.mock.mockito.MockitoTest
ExecutionListener, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener, org.springframework.boot.test.autoconfigure.web.client.MockRestServic
eServerResetTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener, org.springframework.t
est.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.conte
xt.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener, org.springframework.test.context.event.EventPubl
ishingTestExecutionListener]
2020-06-03 11:33:16.364  INFO 14540 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Using TestExecutionListeners: [org.springframework.test.context.web.ServletTestExecutionListener@848f6dd, org.springframework.test.context.support.
DirtiesContextBeforeModesTestExecutionListener@8ad99cd, org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener@1df8e97b, org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener@4974318d, org.s
pringframework.test.context.support.DirtiesContextTestExecutionListener@645d860, org.springframework.test.context.transaction.TransactionalTestExecutionListener@62c25a94, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener@38abd48
6, org.springframework.test.context.event.EventPublishingTestExecutionListener@50bb6247, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener@789536e8, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecution
Listener@8f3c594, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener@6e1a3fe8, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener@6538c136, org.
springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener@344b890f]

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.7.RELEASE)

2020-06-03 11:33:16.433  INFO 14540 --- [           main] c.e.s.c.r.p.ProductPatchControllerTest   : Starting ProductPatchControllerTest on GFI10959 with PID 14540 (started by gotorres_sel in C:\Users\gotorres_sel\Desktop\shoppingcart)
2020-06-03 11:33:16.434  INFO 14540 --- [           main] c.e.s.c.r.p.ProductPatchControllerTest   : No active profile set, falling back to default profiles: default
2020-06-03 11:33:17.443  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 149 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:17.590  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 130 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:17.985  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-06-03 11:33:18.265  INFO 14540 --- [           main] o.s.b.t.m.w.SpringBootMockServletContext : Initializing Spring TestDispatcherServlet ''
2020-06-03 11:33:18.266  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Initializing Servlet ''
2020-06-03 11:33:18.282  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Completed initialization in 16 ms
2020-06-03 11:33:18.295  INFO 14540 --- [           main] c.e.s.c.r.p.ProductPatchControllerTest   : Started ProductPatchControllerTest in 1.926 seconds (JVM running for 21.681)
2020-06-03 11:33:18.380  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.993 s - in com.evobank.shopping.controllers.restful.products.ProductPatchControllerTest
[INFO] Running com.evobank.shopping.controllers.restful.products.ProductPostControllerTest
2020-06-03 11:33:18.386  INFO 14540 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Neither @ContextConfiguration nor @ContextHierarchy found for test class [com.evobank.shopping.controllers.restful.products.ProductPostControllerT
est], using SpringBootContextLoader
2020-06-03 11:33:18.387  INFO 14540 --- [           main] o.s.t.c.support.AbstractContextLoader    : Could not detect default resource locations for test class [com.evobank.shopping.controllers.restful.products.ProductPostControllerTest]: no resou
rce found for suffixes {-context.xml, Context.groovy}.
2020-06-03 11:33:18.387  INFO 14540 --- [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [com.evobank.shopping.controllers.restful.products.ProductPostControllerTest]: Produ
ctPostControllerTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2020-06-03 11:33:18.391  INFO 14540 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration com.evobank.shopping.ShoppingApplication for test class com.evobank.shopping.controllers.restful.products.ProductPo
stControllerTest
2020-06-03 11:33:18.394  INFO 14540 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.boot.test.mock.mockito.MockitoTest
ExecutionListener, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener, org.springframework.boot.test.autoconfigure.web.client.MockRestServic
eServerResetTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener, org.springframework.t
est.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.conte
xt.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener, org.springframework.test.context.event.EventPubl
ishingTestExecutionListener]
2020-06-03 11:33:18.394  INFO 14540 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Using TestExecutionListeners: [org.springframework.test.context.web.ServletTestExecutionListener@5c9f43f6, org.springframework.test.context.support
.DirtiesContextBeforeModesTestExecutionListener@7a30257c, org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener@36e1b827, org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener@8a77298, org.
springframework.test.context.support.DirtiesContextTestExecutionListener@2e810089, org.springframework.test.context.transaction.TransactionalTestExecutionListener@5561cbe0, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener@6e7a6
1eb, org.springframework.test.context.event.EventPublishingTestExecutionListener@5d7aed0e, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener@7b592b60, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecuti
onListener@203cc120, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener@1df499f5, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener@176c15d8, o
rg.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener@255c2e7e]

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.7.RELEASE)

2020-06-03 11:33:18.447  INFO 14540 --- [           main] c.e.s.c.r.p.ProductPostControllerTest    : Starting ProductPostControllerTest on GFI10959 with PID 14540 (started by gotorres_sel in C:\Users\gotorres_sel\Desktop\shoppingcart)
2020-06-03 11:33:18.449  INFO 14540 --- [           main] c.e.s.c.r.p.ProductPostControllerTest    : No active profile set, falling back to default profiles: default
2020-06-03 11:33:19.294  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 96 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:19.405  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 103 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:19.823  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-06-03 11:33:20.069  INFO 14540 --- [           main] o.s.b.t.m.w.SpringBootMockServletContext : Initializing Spring TestDispatcherServlet ''
2020-06-03 11:33:20.069  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Initializing Servlet ''
2020-06-03 11:33:20.081  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Completed initialization in 12 ms
2020-06-03 11:33:20.090  INFO 14540 --- [           main] c.e.s.c.r.p.ProductPostControllerTest    : Started ProductPostControllerTest in 1.692 seconds (JVM running for 23.476)
2020-06-03 11:33:20.114  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.718 s - in com.evobank.shopping.controllers.restful.products.ProductPostControllerTest
[INFO] Running com.evobank.shopping.controllers.restful.products.ProductPutControllerTest
2020-06-03 11:33:20.118  INFO 14540 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Neither @ContextConfiguration nor @ContextHierarchy found for test class [com.evobank.shopping.controllers.restful.products.ProductPutControllerTe
st], using SpringBootContextLoader
2020-06-03 11:33:20.120  INFO 14540 --- [           main] o.s.t.c.support.AbstractContextLoader    : Could not detect default resource locations for test class [com.evobank.shopping.controllers.restful.products.ProductPutControllerTest]: no resour
ce found for suffixes {-context.xml, Context.groovy}.
2020-06-03 11:33:20.121  INFO 14540 --- [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [com.evobank.shopping.controllers.restful.products.ProductPutControllerTest]: Produc
tPutControllerTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2020-06-03 11:33:20.124  INFO 14540 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration com.evobank.shopping.ShoppingApplication for test class com.evobank.shopping.controllers.restful.products.ProductPu
tControllerTest
2020-06-03 11:33:20.127  INFO 14540 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.boot.test.mock.mockito.MockitoTest
ExecutionListener, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener, org.springframework.boot.test.autoconfigure.web.client.MockRestServic
eServerResetTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener, org.springframework.t
est.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.conte
xt.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener, org.springframework.test.context.event.EventPubl
ishingTestExecutionListener]
2020-06-03 11:33:20.128  INFO 14540 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Using TestExecutionListeners: [org.springframework.test.context.web.ServletTestExecutionListener@304542ec, org.springframework.test.context.support
.DirtiesContextBeforeModesTestExecutionListener@43687885, org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener@5c609f47, org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener@3004c204, org
.springframework.test.context.support.DirtiesContextTestExecutionListener@2a4ca4ca, org.springframework.test.context.transaction.TransactionalTestExecutionListener@2ae04d56, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener@72a2
65ea, org.springframework.test.context.event.EventPublishingTestExecutionListener@64209d58, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener@2b851fe2, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecut
ionListener@3a76d39, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener@624bc592, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener@2614ede, or
g.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener@1183b7f]

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.7.RELEASE)

2020-06-03 11:33:20.191  INFO 14540 --- [           main] c.e.s.c.r.p.ProductPutControllerTest     : Starting ProductPutControllerTest on GFI10959 with PID 14540 (started by gotorres_sel in C:\Users\gotorres_sel\Desktop\shoppingcart)
2020-06-03 11:33:20.192  INFO 14540 --- [           main] c.e.s.c.r.p.ProductPutControllerTest     : No active profile set, falling back to default profiles: default
2020-06-03 11:33:20.952  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 104 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:21.064  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 103 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:21.389  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-06-03 11:33:21.621  INFO 14540 --- [           main] o.s.b.t.m.w.SpringBootMockServletContext : Initializing Spring TestDispatcherServlet ''
2020-06-03 11:33:21.621  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Initializing Servlet ''
2020-06-03 11:33:21.639  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Completed initialization in 18 ms
2020-06-03 11:33:21.654  INFO 14540 --- [           main] c.e.s.c.r.p.ProductPutControllerTest     : Started ProductPutControllerTest in 1.523 seconds (JVM running for 25.04)
2020-06-03 11:33:21.690  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.7.RELEASE)

2020-06-03 11:33:21.743  INFO 14540 --- [           main] c.e.s.c.r.p.ProductPutControllerTest     : Starting ProductPutControllerTest on GFI10959 with PID 14540 (started by gotorres_sel in C:\Users\gotorres_sel\Desktop\shoppingcart)
2020-06-03 11:33:21.744  INFO 14540 --- [           main] c.e.s.c.r.p.ProductPutControllerTest     : No active profile set, falling back to default profiles: default
2020-06-03 11:33:22.345  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 102 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:22.446  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 91 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:22.799  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-06-03 11:33:23.039  INFO 14540 --- [           main] o.s.b.t.m.w.SpringBootMockServletContext : Initializing Spring TestDispatcherServlet ''
2020-06-03 11:33:23.039  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Initializing Servlet ''
2020-06-03 11:33:23.048  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Completed initialization in 9 ms
2020-06-03 11:33:23.055  INFO 14540 --- [           main] c.e.s.c.r.p.ProductPutControllerTest     : Started ProductPutControllerTest in 1.36 seconds (JVM running for 26.441)
2020-06-03 11:33:23.068  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.7.RELEASE)

2020-06-03 11:33:23.101  INFO 14540 --- [           main] c.e.s.c.r.p.ProductPutControllerTest     : Starting ProductPutControllerTest on GFI10959 with PID 14540 (started by gotorres_sel in C:\Users\gotorres_sel\Desktop\shoppingcart)
2020-06-03 11:33:23.102  INFO 14540 --- [           main] c.e.s.c.r.p.ProductPutControllerTest     : No active profile set, falling back to default profiles: default
2020-06-03 11:33:23.475  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 66 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:23.563  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 83 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:23.884  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-06-03 11:33:24.084  INFO 14540 --- [           main] o.s.b.t.m.w.SpringBootMockServletContext : Initializing Spring TestDispatcherServlet ''
2020-06-03 11:33:24.085  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Initializing Servlet ''
2020-06-03 11:33:24.096  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Completed initialization in 11 ms
2020-06-03 11:33:24.103  INFO 14540 --- [           main] c.e.s.c.r.p.ProductPutControllerTest     : Started ProductPutControllerTest in 1.032 seconds (JVM running for 27.489)
2020-06-03 11:33:24.131  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3.969 s - in com.evobank.shopping.controllers.restful.products.ProductPutControllerTest
[INFO] Running com.evobank.shopping.controllers.restful.products.ProductsGetControllerTest
2020-06-03 11:33:24.136  INFO 14540 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Neither @ContextConfiguration nor @ContextHierarchy found for test class [com.evobank.shopping.controllers.restful.products.ProductsGetControllerT
est], using SpringBootContextLoader
2020-06-03 11:33:24.137  INFO 14540 --- [           main] o.s.t.c.support.AbstractContextLoader    : Could not detect default resource locations for test class [com.evobank.shopping.controllers.restful.products.ProductsGetControllerTest]: no resou
rce found for suffixes {-context.xml, Context.groovy}.
2020-06-03 11:33:24.138  INFO 14540 --- [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [com.evobank.shopping.controllers.restful.products.ProductsGetControllerTest]: Produ
ctsGetControllerTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2020-06-03 11:33:24.141  INFO 14540 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration com.evobank.shopping.ShoppingApplication for test class com.evobank.shopping.controllers.restful.products.ProductsG
etControllerTest
2020-06-03 11:33:24.144  INFO 14540 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.boot.test.mock.mockito.MockitoTest
ExecutionListener, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener, org.springframework.boot.test.autoconfigure.web.client.MockRestServic
eServerResetTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener, org.springframework.t
est.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.conte
xt.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener, org.springframework.test.context.event.EventPubl
ishingTestExecutionListener]
2020-06-03 11:33:24.144  INFO 14540 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Using TestExecutionListeners: [org.springframework.test.context.web.ServletTestExecutionListener@75b8328d, org.springframework.test.context.support
.DirtiesContextBeforeModesTestExecutionListener@3758f3a3, org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener@2aa6a642, org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener@4d0b7be7, org
.springframework.test.context.support.DirtiesContextTestExecutionListener@79130491, org.springframework.test.context.transaction.TransactionalTestExecutionListener@9a625fb, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener@162d0
63b, org.springframework.test.context.event.EventPublishingTestExecutionListener@ef935a, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener@6139285a, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecution
Listener@5988407b, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener@27ea99af, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener@5be3bb4b, org
.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener@73b02395]

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.7.RELEASE)

2020-06-03 11:33:24.180  INFO 14540 --- [           main] c.e.s.c.r.p.ProductsGetControllerTest    : Starting ProductsGetControllerTest on GFI10959 with PID 14540 (started by gotorres_sel in C:\Users\gotorres_sel\Desktop\shoppingcart)
2020-06-03 11:33:24.180  INFO 14540 --- [           main] c.e.s.c.r.p.ProductsGetControllerTest    : No active profile set, falling back to default profiles: default
2020-06-03 11:33:24.741  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 107 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:24.841  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 94 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:25.214  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-06-03 11:33:25.592  INFO 14540 --- [           main] o.s.b.t.m.w.SpringBootMockServletContext : Initializing Spring TestDispatcherServlet ''
2020-06-03 11:33:25.592  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Initializing Servlet ''
2020-06-03 11:33:25.605  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Completed initialization in 13 ms
2020-06-03 11:33:25.616  INFO 14540 --- [           main] c.e.s.c.r.p.ProductsGetControllerTest    : Started ProductsGetControllerTest in 1.469 seconds (JVM running for 29.002)
2020-06-03 11:33:25.635  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.7.RELEASE)

2020-06-03 11:33:25.690  INFO 14540 --- [           main] c.e.s.c.r.p.ProductsGetControllerTest    : Starting ProductsGetControllerTest on GFI10959 with PID 14540 (started by gotorres_sel in C:\Users\gotorres_sel\Desktop\shoppingcart)
2020-06-03 11:33:25.691  INFO 14540 --- [           main] c.e.s.c.r.p.ProductsGetControllerTest    : No active profile set, falling back to default profiles: default
2020-06-03 11:33:26.104  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 67 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:26.167  INFO 14540 --- [           main] org.reflections.Reflections              : Reflections took 58 ms to scan 2 urls, producing 46 keys and 122 values
2020-06-03 11:33:26.424  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-06-03 11:33:26.589  INFO 14540 --- [           main] o.s.b.t.m.w.SpringBootMockServletContext : Initializing Spring TestDispatcherServlet ''
2020-06-03 11:33:26.589  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Initializing Servlet ''
2020-06-03 11:33:26.598  INFO 14540 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Completed initialization in 9 ms
2020-06-03 11:33:26.604  INFO 14540 --- [           main] c.e.s.c.r.p.ProductsGetControllerTest    : Started ProductsGetControllerTest in 0.964 seconds (JVM running for 29.99)
2020-06-03 11:33:26.623  INFO 14540 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 2.505 s - in com.evobank.shopping.controllers.restful.products.ProductsGetControllerTest
[INFO] Running com.evobank.shopping.submodules.carts.application.addproduct.AddProductToCartIICommandHandlerTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.94 s - in com.evobank.shopping.submodules.carts.application.addproduct.AddProductToCartIICommandHandlerTest
[INFO] Running com.evobank.shopping.submodules.carts.application.create.CreateCartCommandHandlerTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.009 s - in com.evobank.shopping.submodules.carts.application.create.CreateCartCommandHandlerTest
[INFO] Running com.evobank.shopping.submodules.products.application.create.CreateProductIICommandHandlerTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.301 s - in com.evobank.shopping.submodules.products.application.create.CreateProductIICommandHandlerTest
[INFO] Running com.evobank.shopping.submodules.products.application.search_all.SearchAllProductsIIQueryHandlerTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.008 s - in com.evobank.shopping.submodules.products.application.search_all.SearchAllProductsIIQueryHandlerTest
[INFO] Running com.evobank.shopping.submodules.products.application.update.UpdateProductIICommandHandlerTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.007 s - in com.evobank.shopping.submodules.products.application.update.UpdateProductIICommandHandlerTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 22, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- maven-jar-plugin:3.1.2:jar (default-jar) @ shopping ---
[INFO] Building jar: C:\Users\gotorres_sel\Desktop\shoppingcart\target\shopping-0.0.1-SNAPSHOT.jar
[INFO]
[INFO] --- spring-boot-maven-plugin:2.2.7.RELEASE:repackage (repackage) @ shopping ---
[INFO] Replacing main artifact with repackaged archive
[INFO]
[INFO] --- jacoco-maven-plugin:0.8.3:report (jacoco-site) @ shopping ---
[INFO] Loading execution data file C:\Users\gotorres_sel\Desktop\shoppingcart\target\coverage-reports\jacoco-unit.exec
[INFO] Analyzed bundle 'shoppingcart' with 77 classes
[INFO]
[INFO] --- maven-resources-plugin:3.1.0:resources (default-resources) @ shopping ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ shopping ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 95 source files to C:\Users\gotorres_sel\Desktop\shoppingcart\target\classes
[INFO] /C:/Users/gotorres_sel/Desktop/shoppingcart/src/main/java/com/evobank/shopping/shared/infrastructure/bus/IQuery/QueryHandlersInformation.java: Some input files use unchecked or unsafe operations.
[INFO] /C:/Users/gotorres_sel/Desktop/shoppingcart/src/main/java/com/evobank/shopping/shared/infrastructure/bus/IQuery/QueryHandlersInformation.java: Recompile with -Xlint:unchecked for details.
[INFO]
[INFO] --- maven-resources-plugin:3.1.0:testResources (default-testResources) @ shopping ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\gotorres_sel\Desktop\shoppingcart\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ shopping ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 37 source files to C:\Users\gotorres_sel\Desktop\shoppingcart\target\test-classes
[INFO]
[INFO] --- jacoco-maven-plugin:0.8.3:prepare-agent (jacoco-initialize) @ shopping ---
[INFO] argLine set to -javaagent:C:\\Users\\gotorres_sel\\.m2\\repository\\org\\jacoco\\org.jacoco.agent\\0.8.3\\org.jacoco.agent-0.8.3-runtime.jar=destfile=C:\\Users\\gotorres_sel\\Desktop\\shoppingcart\\target\\coverage-reports\\jacoco-unit.exec,
append=true,excludes=*MethodAccess,output=file
[INFO]
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ shopping ---
[INFO] Skipping execution of surefire because it has already been run for this configuration
[INFO]
[INFO] --- maven-jar-plugin:3.1.2:jar (default-jar) @ shopping ---
[INFO] Building jar: C:\Users\gotorres_sel\Desktop\shoppingcart\target\shopping-0.0.1-SNAPSHOT.jar
[INFO]
[INFO] --- spring-boot-maven-plugin:2.2.7.RELEASE:repackage (repackage) @ shopping ---
[INFO] Replacing main artifact with repackaged archive
[INFO]
[INFO] --- jacoco-maven-plugin:0.8.3:report (jacoco-site) @ shopping ---
[INFO] Loading execution data file C:\Users\gotorres_sel\Desktop\shoppingcart\target\coverage-reports\jacoco-unit.exec
[INFO] Analyzed bundle 'shoppingcart' with 77 classes
[INFO]
[INFO] --- maven-install-plugin:2.5.2:install (default-install) @ shopping ---
[INFO] Installing C:\Users\gotorres_sel\Desktop\shoppingcart\target\shopping-0.0.1-SNAPSHOT.jar to C:\Users\gotorres_sel\.m2\repository\com\evobanco\shopping\0.0.1-SNAPSHOT\shopping-0.0.1-SNAPSHOT.jar
[INFO] Installing C:\Users\gotorres_sel\Desktop\shoppingcart\pom.xml to C:\Users\gotorres_sel\.m2\repository\com\evobanco\shopping\0.0.1-SNAPSHOT\shopping-0.0.1-SNAPSHOT.pom
[INFO]
[INFO] -----------------------< com.evobanco:shopping >------------------------
[INFO] Building shoppingcart 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- sonar-maven-plugin:3.7.0.1746:sonar (default-cli) @ shopping ---
[INFO] User cache: C:\Users\gotorres_sel\.sonar\cache
[INFO] SonarQube version: 8.2.0
[INFO] Default locale: "es_ES", source code encoding: "UTF-8"
[WARNING] SonarScanner will require Java 11 to run starting in SonarQube 8.x
[INFO] Load global settings
[INFO] Load global settings (done) | time=489ms
[INFO] Server id: BF41A1F2-AXEY7pH-yRfxHMYB3Wj0
[INFO] User cache: C:\Users\gotorres_sel\.sonar\cache
[INFO] Load/download plugins
[INFO] Load plugins index
[INFO] Load plugins index (done) | time=147ms
[INFO] Load/download plugins (done) | time=2947ms
[INFO] Process project properties
[INFO] Process project properties (done) | time=30ms
[INFO] Execute project builders
[INFO] Execute project builders (done) | time=7ms
[INFO] Project key: com.evobanco:shopping
[INFO] Base dir: C:\Users\gotorres_sel\Desktop\shoppingcart
[INFO] Working dir: C:\Users\gotorres_sel\Desktop\shoppingcart\target\sonar
[INFO] Load project settings for component key: 'com.evobanco:shopping'
[INFO] Load quality profiles
[INFO] Load quality profiles (done) | time=361ms
[INFO] Load active rules
[INFO] Load active rules (done) | time=5062ms
[INFO] Indexing files...
[INFO] Project configuration:
[INFO] 133 files indexed
[INFO] 0 files ignored because of scm ignore settings
[INFO] Quality profile for java: Sonar way
[INFO] Quality profile for xml: Sonar way
[INFO] ------------- Run sensors on module shoppingcart
[INFO] Load metrics repository
[INFO] Load metrics repository (done) | time=65ms
[INFO] Sensor JavaSquidSensor [java]
[INFO] Configured Java source version (sonar.java.source): 8
[INFO] JavaClasspath initialization
[INFO] JavaClasspath initialization (done) | time=23ms
[INFO] JavaTestClasspath initialization
[INFO] JavaTestClasspath initialization (done) | time=11ms
[INFO] Java Main Files AST scan
[INFO] 95 source files to be analyzed
[INFO] Load project repositories
[INFO] Load project repositories (done) | time=14ms
[INFO] 45/95 files analyzed, current file: src/main/java/com/evobank/shopping/submodules/products/domain/factories/ProductFactory.java
[INFO] 95/95 source files have been analyzed
[INFO] Java Main Files AST scan (done) | time=16475ms
[INFO] Java Test Files AST scan
[INFO] 37 source files to be analyzed
[INFO] Java Test Files AST scan (done) | time=3759ms
[INFO] 37/37 source files have been analyzed
[INFO] Sensor JavaSquidSensor [java] (done) | time=20675ms
[INFO] Sensor SonarCSS Rules [cssfamily]
[INFO] No CSS, PHP, HTML or VueJS files are found in the project. CSS analysis is skipped.
[INFO] Sensor SonarCSS Rules [cssfamily] (done) | time=10ms
[INFO] Sensor JaCoCo XML Report Importer [jacoco]
[INFO] Sensor JaCoCo XML Report Importer [jacoco] (done) | time=172ms
[INFO] Sensor SurefireSensor [java]
[INFO] parsing [C:\Users\gotorres_sel\Desktop\shoppingcart\target\surefire-reports]
[INFO] Sensor SurefireSensor [java] (done) | time=241ms
[INFO] Sensor Removed properties sensor [java]
[WARNING] Property 'sonar.jacoco.reportPath' is no longer supported. Use JaCoCo's xml report and sonar-jacoco plugin.
[INFO] Sensor Removed properties sensor [java] (done) | time=14ms
[INFO] Sensor JavaXmlSensor [java]
[INFO] 1 source files to be analyzed
[INFO] Sensor JavaXmlSensor [java] (done) | time=365ms
[INFO] 1/1 source files have been analyzed
[INFO] Sensor HTML [web]
[INFO] Sensor HTML [web] (done) | time=9ms
[INFO] Sensor XML Sensor [xml]
[INFO] 1 source files to be analyzed
[INFO] Sensor XML Sensor [xml] (done) | time=280ms
[INFO] 1/1 source files have been analyzed
[INFO] ------------- Run sensors on project
[INFO] Sensor Zero Coverage Sensor
[INFO] Sensor Zero Coverage Sensor (done) | time=8ms
[INFO] Sensor Java CPD Block Indexer
[INFO] Sensor Java CPD Block Indexer (done) | time=136ms
[INFO] SCM Publisher SCM provider for this project is: git
[INFO] SCM Publisher 133 source files to be analyzed
[INFO] SCM Publisher 133/133 source files have been analyzed (done) | time=1404ms
[INFO] CPD Executor 61 files had no CPD blocks
[INFO] CPD Executor Calculating CPD for 34 files
[INFO] CPD Executor CPD calculation finished (done) | time=90ms
[INFO] Analysis report generated in 672ms, dir size=329 KB
[INFO] Analysis report compressed in 3239ms, zip size=246 KB
[INFO] Analysis report uploaded in 5104ms
[INFO] ANALYSIS SUCCESSFUL, you can browse http://localhost:9000/dashboard?id=com.evobanco%3Ashopping
[INFO] Note that you will be able to access the updated dashboard once the server has processed the submitted analysis report
[INFO] More about the report processing at http://localhost:9000/api/ce/task?id=AXJ5iGlzsjnkqdn7nwgu
[INFO] Analysis total time: 46.420 s
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  02:22 min
[INFO] Finished at: 2020-06-03T11:34:43+02:00
[INFO] ------------------------------------------------------------------------
~~~

#### AHORA REVISAR EN EL NAVEGADOR (http://localhost:9000) EL RESULTADO DE LA EVALUACION DE SONAR

### Enlaces de interes

[Inicio](https://github.com/gotorresevo/proyecto-base-spring-boot)  
[Ver como se implemento el modulo Shopping](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/src/main/java/com/evobank/shopping)  
[Ver como se implemento el submodulo CARTS del modulo Shopping](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/src/main/java/com/evobank/shopping/submodules/carts)  
[Ver como se implemento las pruebas unitarias del Controlador para CREAR CARRITO](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/src/test/java/com/evobank/shopping/controllers)  
[Ver como se implemento las pruebas unitarias del caso de uso CREAR CARRITO](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/src/test/java/com/evobank/shopping/submodules)  
[Configuracion de Sonar en local](https://github.com/gotorresevo/proyecto-base-spring-boot/tree/master/sonarqube)  