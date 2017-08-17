Tutorial de configuração do servidor de aplicação e do SGBD.

Para esse projeto funcionar corretamente, é preciso ter um servidor de aplicação e um gerenciador de banco de dados (SGBD). 

Esse projeto foi testado com o servidor de aplicação Wildfly 10.1.0.Final e com o SGBD PostgreSQL 9.6. 

Para integrar o Wildfly com uma base de dados do PostgreSQL, é preciso criar um DataSource no arquivo '<WILDFLY_HOME_DIR>/standalone/configuration/standalone.xml'. Procure a tag '<datasources>' e adicione o conteúdo necessário:

            <datasources>
                ...
                <datasource jta="true" jndi-name="java:jboss/datasources/MeuDataSource" pool-name="MeuDataSource" enabled="true" use-java-context="true">
                    <connection-url>jdbc:postgresql://localhost:5432/postgres</connection-url>
                    <driver>postgresql</driver>
                    <security>
                        <user-name>postgres</user-name>
                        <password>123456</password>
                    </security>
                </datasource>
                <drivers>
                    <driver name="postgresql" module="org.postgresql">
                        <xa-datasource-class>org.postgresql.xa.PGXADataSource</xa-datasource-class>
                    </driver>
                </drivers>
                ...
            </datasources>
 
Obs.: A URL de conexão 'jdbc:postgresql://localhost:5432/postgres' e o usuário 'postgres' são apenas sugestões, pois normalmente acessam a base de dados padrão do PostgreSQL logo após sua instalação. Porém, recomenda-se a criação de usuário e base de dados específicos para um sistema em produção.
 
Outra configuração a ser feita no mesmo arquivo 'standalone.xml' diz respeito à criação de um Security Domain. O Security Domain é utilizado para definir como um usuário se autentica e recebe autorização para acessar os recursos da aplicação. Procure a tag '<security-domains>' e adicione o conteúdo necessário:

            <security-domains>
                ...
                <security-domain name="MeuSecurityDomain" cache-type="default">
                    <authentication>
                        <login-module code="Database" flag="required">
                            <module-option name="dsJndiName" value="java:jboss/datasources/MeuDataSource"/>
                            <module-option name="rolesQuery" value="SELECT role, 'Roles' FROM users WHERE username=?"/>
                            <module-option name="hashAlgorithm" value="MD5"/>
                            <module-option name="hashEncoding" value="hex"/>
                            <module-option name="principalsQuery" value="SELECT password from users WHERE username=?"/>
                        </login-module>
                    </authentication>
                    <authorization>
                        <policy-module code="Database" flag="required">
                            <module-option name="dsJndiName" value="java:jboss/datasources/MeuDataSource"/>
                            <module-option name="rolesQuery" value="SELECT role, 'Roles' FROM users WHERE username=?"/>
                            <module-option name="hashAlgorithm" value="MD5"/>
                            <module-option name="hashEncoding" value="hex"/>
                            <module-option name="principalsQuery" value="SELECT password from users WHERE username=?"/>
                        </policy-module>
                    </authorization>
                </security-domain>
                ...
            </security-domains>
 
Obs.: note que o conteúdo acima faz referência ao DataSource configurado anteriormente nesse tutorial. Além disso, o conteúdo também faz referência à tabela 'users', que deve ser criada na base de dados referenciada pelo DataSource. Para isso, conecte-se à base de dados através de uma ferramenta de acesso ao PostgreSQL (como o pgAdmin, por exemplo) e execute o(s) script(s) presente(s) no diretório 'src/main/resources/sql/' desse projeto. Será criado um usuário 'admin' com senha 'admin' e perfil 'ADMINISTRATOR' para acesso à aplicação (veja o script para outros usuários).
 
Além disso, é preciso adicionar no servidor de aplicação um driver JDBC de acesso ao PostgreSQL. Para isso, crie o arquivo '<WILDFLY_HOME_DIR>/modules/system/layers/base/org/postgresql/main/module.xml' com o seguinte conteúdo:

<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.3" name="org.postgresql">
  <resources>
    <resource-root path="postgresql-42.1.3.jar"/>
  </resources>
  <dependencies>
     <module name="javax.api"/>
     <module name="javax.transaction.api"/>
   </dependencies>
</module>

Obs.: note que o conteúdo desse XML faz referência ao jar do driver JDBC do PostgreSQL. Esse jar pode ser baixado do endereço 'https://mvnrepository.com/artifact/org.postgresql/postgresql/42.1.3' e deve ser colocado no mesmo diretório do arquivo 'module.xml'.

Pronto! Digite 'mvn clean package' a partir do diretório raiz do projeto para compilar e empacotar a aplicação. O pacote WAR será criado no diretório 'target'. 

Se for utilizar a IDE Eclipse para compilar e fazer deploy da aplicação, é preciso instalar o plugin 'm2e-apt' a fim de habilitar o recurso de Annotation Processing utilizado pela biblioteca MapStruct. O plugin pode ser instalado a partir do Eclipse Market. Depois de instalar o plugin, entre em 'Eclipse -> Preferências -> Maven -> Annotation Processing' e selecione a opção 'Automatically configure JDT APT'.

