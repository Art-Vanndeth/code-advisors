package com.example.forumcodeadvisors.init;

import com.example.forumcodeadvisors.domain.Tag;
import com.example.forumcodeadvisors.feature.tag.repository.TagRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TagInit {

    private final TagRepository forumTagRepository;

    @PostConstruct
    public void init() {
        if (forumTagRepository.count() == 0) {
            Tag java = new Tag();
            java.setIsDeleted(false);
            java.setName("java");
            java.setDescription("Java គឺជាភាសាកម្មវិធីកូដប្រភពខ្ពស់ដែលបង្កើតឡើងដើម្បីអនុញ្ញាតឱ្យអ្នកអភិវឌ្ឍសរសេរកម្មវិធីដែលអាចដំណើរការបាននៅលើបរិស្ថានផ្សេងៗគ្នា (cross-platform)។ វាបានបង្កើតឡើងនៅឆ្នាំ 1995 ដោយក្រុមហ៊ុន Sun Microsystems (ពេលនេះជាកម្មសិទ្ធិរបស់ក្រុមហ៊ុន Oracle)។");

            Tag spring = new Tag();
            spring.setName("spring-boot");
            spring.setIsDeleted(false);
            spring.setDescription("Spring Boot គឺជាផ្នែកមួយនៃ Spring Framework ដែលងាយស្រួលប្រើ និងមានគោលបំណងបំផុសសមត្ថភាពអភិវឌ្ឍកម្មវិធី Java ជា Microservices ឬកម្មវិធីដែលមានរចនាសម្ព័ន្ធធំៗ។ វាបង្កើតឡើងដើម្បីកាត់បន្ថយការកំណត់រចនាសម្ព័ន្ធ (Configuration) និងបង្កើតកម្មវិធី Java ដែលអាចដំណើរការបានឆាប់រហ័ស។");

            Tag kotlin = new Tag();
            kotlin.setName("kotlin");
            kotlin.setIsDeleted(false);
            kotlin.setDescription("Kotlin គឺជា​ភាសាកូដប្រភព​ខ្ពស់ ដែលបង្កើតឡើងដោយ JetBrains ក្នុងឆ្នាំ 2011 និងសរសេរដោយប្រើ JVM (Java Virtual Machine)។ វាមានលក្ខណៈស្របទៅនឹង Java ហើយមានគោលបំណងផ្តល់ភាពងាយស្រួល និងសុវត្ថិភាពជាង Java។ Kotlin ត្រូវបានប្រើសម្រាប់ការអភិវឌ្ឍកម្មវិធី Android, Web, និង Backend។");

            Tag go = new Tag();
            go.setName("golang");
            go.setIsDeleted(false);
            go.setDescription("Golang ឬ Go គឺជា​ភាសាកូដដែលបង្កើតឡើងដោយ Google ក្នុងឆ្នាំ 2009 ដើម្បីផ្តល់នូវប្រសិទ្ធភាពខ្ពស់, ការគាំទ្រទម្រង់ Concurrency, និងភាពងាយស្រួលក្នុងការប្រើប្រាស់។ វាត្រូវបានប្រើសម្រាប់ការអភិវឌ្ឍប្រព័ន្ធ Microservices, Network Tools, និង Cloud Applications។");

            Tag python = new Tag();
            python.setName("python");
            python.setIsDeleted(false);
            python.setDescription("Python គឺជា​ភាសាកូដប្រភព​ខ្ពស់ដែលងាយស្រួលសិក្សា និងប្រើប្រាស់។ វាត្រូវបានប្រើសម្រាប់កម្មវិធី Web, Data Science, Machine Learning, និងការបង្កើត Script ជាច្រើន។");

            Tag javascript = new Tag();
            javascript.setName("javascript");
            javascript.setIsDeleted(false);
            javascript.setDescription("JavaScript គឺជា​ភាសាកូដ client-side ដែលត្រូវបានប្រើសម្រាប់បន្ថែមលក្ខណៈ interactive ក្នុង Web Applications និងមានសារៈសំខាន់ក្នុងការអភិវឌ្ឍ Frontend និង Backend។");

            Tag typescript = new Tag();
            typescript.setName("typescript");
            typescript.setIsDeleted(false);
            typescript.setDescription("TypeScript គឺជា​ភាសាបន្ថែមនៅលើ JavaScript ដែលផ្តល់នូវ Static Typing និងឧបករណ៍ច្រើនសម្រាប់ការអភិវឌ្ឍកម្មវិធីធំៗដែលមានស្ថេរភាព។");

            Tag html = new Tag();
            html.setName("html");
            html.setIsDeleted(false);
            html.setDescription("HTML (HyperText Markup Language) គឺជាភាសាមូលដ្ឋានសម្រាប់បង្កើតគេហទំព័រ។ វាត្រូវបានប្រើដើម្បីបែងចែក និងរៀបចំព័ត៌មាននៅលើ Web។");

            Tag css = new Tag();
            css.setName("css");
            css.setIsDeleted(false);
            css.setDescription("CSS (Cascading Style Sheets) គឺជា​ភាសាដើម្បីរចនារូបរាងនៃគេហទំព័រ ដូចជា ពណ៌, ការរៀបចំ Layout, និងការរចនាទូទៅ។");

            Tag bootstrap = new Tag();
            bootstrap.setName("bootstrap");
            bootstrap.setIsDeleted(false);
            bootstrap.setDescription("Bootstrap គឺជា Framework រចនាមុខមាត់ដែលផ្តល់ Component និង Utility ច្រើនសម្រាប់បង្កើតគេហទំព័រដែលមានភាពឆបគ្នានឹងឧបករណ៍ផ្សេងៗ។");

            Tag tailwind = new Tag();
            tailwind.setName("tailwind");
            tailwind.setIsDeleted(false);
            tailwind.setDescription("Tailwind CSS គឺជា Utility-First CSS Framework ដែលផ្តល់ Class ច្រើនសម្រាប់បង្កើតការរចនាប្លង់ដែលអាចប្តូរបានយ៉ាងឆាប់រហ័ស។");

            Tag sql = new Tag();
            sql.setName("sql");
            sql.setIsDeleted(false);
            sql.setDescription("SQL (Structured Query Language) គឺជា​ភាសាសម្រាប់គ្រប់គ្រងទិន្នន័យនៅក្នុង Database ដែលអាចប្រើសម្រាប់ការស្វែងរក, បន្ថែម, និងកែប្រែទិន្នន័យ។");


            Tag postgresql = new Tag();
            postgresql.setName("postgresql");
            postgresql.setIsDeleted(false);
            postgresql.setDescription("PostgreSQL គឺជា Database Management System ប្រភពបើកចំហ ដែលមានប្រសិទ្ធភាពខ្ពស់ និងគាំទ្រទិន្នន័យប្រភេទទំនាក់ទំនង (Relational) និងប្រភេទ JSON, XML, និងប្រព័ន្ធ Spatial។");

            Tag mysql = new Tag();
            mysql.setName("mysql");
            mysql.setIsDeleted(false);
            mysql.setDescription("MySQL គឺជា Relational Database Management System (RDBMS) ដែលប្រើសម្រាប់គ្រប់គ្រងទិន្នន័យប្រភេទតារាងជាមួយភាពឆាប់រហ័ស និងស្ថេរភាព។");

            Tag mongodb = new Tag();
            mongodb.setName("mongodb");
            mongodb.setIsDeleted(false);
            mongodb.setDescription("MongoDB គឺជា Database ប្រភេទ NoSQL ដែលសន្សំទិន្នន័យជាទម្រង់ BSON (Binary JSON) ហើយមានសមត្ថភាពខ្ពស់សម្រាប់ប្រព័ន្ធដែលទាមទារការចងគ្នារហ័ស។");

            Tag redis = new Tag();
            redis.setName("redis");
            redis.setIsDeleted(false);
            redis.setDescription("Redis គឺជា Database ប្រភេទ Key-Value Store ដែលមានប្រសិទ្ធភាពខ្ពស់ក្នុងការចងគ្នា និងប្រើសម្រាប់ការផ្ទុកឯកសារ Cache, Session Management, និង Pub/Sub Messaging។");

            Tag elasticsearch = new Tag();
            elasticsearch.setName("elasticsearch");
            elasticsearch.setIsDeleted(false);
            elasticsearch.setDescription("Elasticsearch គឺជា Search Engine ដែលមានប្រសិទ្ធភាពខ្ពស់សម្រាប់ការស្វែងរក និងវិភាគទិន្នន័យធំៗក្នុងរយៈពេលខ្លី។");

            Tag kafka = new Tag();
            kafka.setName("kafka");
            kafka.setIsDeleted(false);
            kafka.setDescription("Kafka គឺជា Distributed Streaming Platform ដែលប្រើសម្រាប់ Messaging, Logging, និងការផ្ទុក Stream Data ជាស្ថិតិខ្ពស់។");

            Tag docker = new Tag();
            docker.setName("docker");
            docker.setIsDeleted(false);
            docker.setDescription("Docker គឺជា Platform សម្រាប់បង្កើត និងដំណើរការ Container ដែលជួយអភិវឌ្ឍកម្មវិធីក្នុងបរិស្ថានដែលឯករាជ្យពីប្រព័ន្ធប្រតិបត្តិការ។");

            Tag kubernetes = new Tag();
            kubernetes.setName("kubernetes");
            kubernetes.setDescription("Kubernetes គឺជា Open-Source Container Orchestration System ដែលគ្រប់គ្រងការដំណើរការ និងការចែកចាយ Containers នៅលើបណ្ដាញ Server។");

            Tag jenkins = new Tag();
            jenkins.setName("jenkins");
            jenkins.setIsDeleted(false);
            jenkins.setDescription("Jenkins គឺជា Open-Source Automation Server ដែលគាំទ្រ Continuous Integration និង Continuous Deployment (CI/CD) សម្រាប់ការអភិវឌ្ឍកម្មវិធី។");

            Tag aws = new Tag();
            aws.setName("aws");
            aws.setIsDeleted(false);
            aws.setDescription("AWS (Amazon Web Services) គឺជា Cloud Computing Platform ដែលផ្តល់សេវាកម្មសម្រាប់ការរក្សាទិន្នន័យ, គណនា, និងបង្កើតបណ្តាញជាសកល។");


            Tag azure = new Tag();
            azure.setName("azure");
            azure.setIsDeleted(false);
            azure.setDescription("Azure គឺជា Cloud Computing Platform របស់ Microsoft ដែលផ្តល់សេវាកម្មសម្រាប់ការរក្សាទិន្នន័យ, គណនា, និងបង្កើតកម្មវិធីជាសកល។");

            Tag gcp = new Tag();
            gcp.setName("gcp");
            gcp.setIsDeleted(false);
            gcp.setDescription("GCP (Google Cloud Platform) គឺជា Cloud Computing Platform របស់ Google ដែលផ្តល់សេវាកម្មសម្រាប់ការចងគ្នា, ស្តុកទិន្នន័យ, និងវិភាគទិន្នន័យ។");

            Tag ciCd = new Tag();
            ciCd.setName("ci-cd");
            ciCd.setIsDeleted(false);
            ciCd.setDescription("CI/CD (Continuous Integration/Continuous Deployment) គឺជា​លទ្ធកម្មសម្រាប់សាកល្បង, ត្រួតពិនិត្យ, និងដាក់បញ្ចូលកម្មវិធីទៅក្នុងបរិស្ថានផលិតកម្មដោយស្វ័យប្រវត្តិ។");

            Tag git = new Tag();
            git.setName("git");
            git.setIsDeleted(false);
            git.setDescription("Git គឺជា Version Control System ដែលផ្តល់សេវាកម្មសម្រាប់គ្រប់គ្រងការផ្លាស់ប្តូររបស់ Source Code ដោយមានភាពងាយស្រួល និងប្រសិទ្ធភាព។");

            Tag github = new Tag();
            github.setName("github");
            github.setIsDeleted(false);
            github.setDescription("GitHub គឺជា Platform សម្រាប់រដ្ឋបាល Source Code និងគាំទ្រ Git, សម្រាប់ការចែករំលែក និងគ្រប់គ្រងគម្រោងកម្មវិធី។");

            Tag gitlab = new Tag();
            gitlab.setName("gitlab");
            gitlab.setIsDeleted(false);
            gitlab.setDescription("GitLab គឺជា DevOps Platform ដែលផ្តល់នូវសេវាកម្មសម្រាប់ Version Control, CI/CD, និងការគ្រប់គ្រងគម្រោងសម្រាប់ក្រុមអភិវឌ្ឍកម្មវិធី។");

            Tag bitbucket = new Tag();
            bitbucket.setName("bitbucket");
            bitbucket.setIsDeleted(false);
            bitbucket.setDescription("Bitbucket គឺជា Platform សម្រាប់ការគ្រប់គ្រង Source Code និងសេវាកម្មសម្រាប់ Version Control ដោយមានការគាំទ្រ Git និង Mercurial។");

            Tag devops = new Tag();
            devops.setName("devops");
            devops.setIsDeleted(false);
            devops.setDescription("DevOps គឺជា​វិធានសម្រាប់រួមបញ្ចូលក្រុមអភិវឌ្ឍកម្មវិធី និងប្រតិបត្តិការ ដើម្បីធានាភាពរលូនក្នុងការដាក់កម្មវិធី។");

            Tag restApi = new Tag();
            restApi.setName("rest-api");
            restApi.setIsDeleted(false);
            restApi.setDescription("REST API គឺជា Web Service Design Style ដែលអាចផ្ដល់នូវការតភ្ជាប់ចូលទៅក្នុងប្រព័ន្ធតាមប្រព័ន្ធ HTTP ជា Stateless។");

            Tag graphql = new Tag();
            graphql.setName("graphql");
            graphql.setIsDeleted(false);
            graphql.setDescription("GraphQL គឺជា Query Language សម្រាប់ APIs ដែលអាចដាក់សំណើតាមប្រព័ន្ធ Client ដើម្បីទទួលបានទិន្នន័យដែលច្បាស់លាស់។");

            Tag microservices = new Tag();
            microservices.setName("microservices");
            microservices.setIsDeleted(false);
            microservices.setDescription("Microservices គឺជា Architectural Style សម្រាប់ការបែងចែកកម្មវិធីធំៗជាប្រព័ន្ធតូចៗដែលអាចដំណើរការដោយឯករាជ្យ។");

            Tag hibernate = new Tag();
            hibernate.setName("hibernate");
            hibernate.setIsDeleted(false);
            hibernate.setDescription("Hibernate គឺជា ORM Framework សម្រាប់ Java ដែលជួយបម្លែងទិន្នន័យតារាងក្នុង Database ជា Object ដើម្បីធ្វើការប្រើប្រាស់ជាមួយ Java។");

            Tag jpa = new Tag();
            jpa.setName("jpa");
            jpa.setIsDeleted(false);
            jpa.setDescription("JPA (Java Persistence API) គឺជា Specification សម្រាប់ការគ្រប់គ្រង Persistence Data ក្នុងកម្មវិធី Java។");

            Tag springSecurity = new Tag();
            springSecurity.setName("spring-security");
            springSecurity.setIsDeleted(false);
            springSecurity.setDescription("Spring Security គឺជា Framework សម្រាប់ការគ្រប់គ្រង Authentication និង Authorization ក្នុងកម្មវិធី Java Spring។");

            Tag jwt = new Tag();
            jwt.setName("jwt");
            jwt.setIsDeleted(false);
            jwt.setDescription("JWT (JSON Web Token) គឺជា Standard ដែលប្រើសម្រាប់ដាក់ Authentication និង Exchange Information ដោយសុវត្ថិភាព។");

            Tag oauth2 = new Tag();
            oauth2.setName("oauth2");
            oauth2.setIsDeleted(false);
            oauth2.setDescription("OAuth2 គឺជា Framework សម្រាប់ការអនុញ្ញាត Access Token ដើម្បីប្រើប្រាស់ធនធានដោយសុវត្ថិភាព។");

            Tag unitTesting = new Tag();
            unitTesting.setName("unit-testing");
            unitTesting.setIsDeleted(false);
            unitTesting.setDescription("Unit Testing គឺជា​លទ្ធកម្មសម្រាប់សាកល្បង Function ឬ Method តូចៗក្នុងកម្មវិធីដើម្បីធានាប្រសិទ្ធភាព។");

            Tag integrationTesting = new Tag();
            integrationTesting.setName("integration-testing");
            integrationTesting.setIsDeleted(false);
            integrationTesting.setDescription("Integration Testing គឺជា​លទ្ធកម្មសម្រាប់សាកល្បងការប្រើប្រាស់រវាង Module ឬប្រព័ន្ធផ្សេងៗនៅក្នុងកម្មវិធី។");

            Tag jest = new Tag();
            jest.setName("jest");
            jest.setIsDeleted(false);
            jest.setDescription("Jest គឺជា JavaScript Testing Framework សម្រាប់ការសាកល្បង Unit និង Integration ដែលមានប្រសិទ្ធភាពខ្ពស់។");


            Tag mocha = new Tag();
            mocha.setName("mocha");
            mocha.setIsDeleted(false);
            mocha.setDescription("Mocha គឺជា JavaScript Testing Framework ដែលផ្តោតលើការសាកល្បង Unit និង Integration សម្រាប់ Node.js។");

            Tag cypress = new Tag();
            cypress.setName("cypress");
            cypress.setIsDeleted(false);
            cypress.setDescription("Cypress គឺជា JavaScript Testing Tool សម្រាប់សាកល្បង End-to-End ក្នុងកម្មវិធី Web។");

            Tag selenium = new Tag();
            selenium.setName("selenium");
            selenium.setIsDeleted(false);
            selenium.setDescription("Selenium គឺជា Framework សម្រាប់ការសាកល្បងកម្មវិធី Web ដោយស្វ័យប្រវត្តិដោយប្រើ Browser។");

            Tag flutter = new Tag();
            flutter.setName("flutter");
            flutter.setIsDeleted(false);
            flutter.setDescription("Flutter គឺជា UI Toolkit របស់ Google សម្រាប់ការអភិវឌ្ឍកម្មវិធី Mobile, Web, និង Desktop ដោយប្រើ Codebase តែមួយ។");

            Tag dart = new Tag();
            dart.setName("dart");
            dart.setIsDeleted(false);
            dart.setDescription("Dart គឺជា Programming Language របស់ Google សម្រាប់ការអភិវឌ្ឍកម្មវិធីដែលមានប្រសិទ្ធភាពខ្ពស់។");

            Tag rust = new Tag();
            rust.setName("rust");
            rust.setIsDeleted(false);
            rust.setDescription("Rust គឺជា Programming Language ដែលមានសុវត្ថិភាពខ្ពស់ និងសមត្ថភាពលឿនសម្រាប់ការអភិវឌ្ឍកម្មវិធីដែលត្រូវការសមត្ថភាពខ្ពស់។");

            Tag scala = new Tag();
            scala.setName("scala");
            scala.setIsDeleted(false);
            scala.setDescription("Scala គឺជា Programming Language សម្រាប់ JVM ដែលបង្កើតសម្រាប់ការអភិវឌ្ឍកម្មវិធីដែលមានប្រសិទ្ធភាព។");

            Tag c = new Tag();
            c.setName("c");
            c.setIsDeleted(false);
            c.setDescription("C គឺជា Programming Language ដែលមានប្រសិទ្ធភាពសម្រាប់ការអភិវឌ្ឍកម្មវិធីទាប។");

            Tag cpp = new Tag();
            cpp.setName("c++");
            cpp.setIsDeleted(false);
            cpp.setDescription("C++ គឺជា Programming Language ដែលមានប្រសិទ្ធភាពសម្រាប់ការអភិវឌ្ឍកម្មវិធីដែលមានប្រព័ន្ធស្មុគស្មាញ។");

            Tag ruby = new Tag();
            ruby.setName("ruby");
            ruby.setIsDeleted(false);
            ruby.setDescription("Ruby គឺជា Programming Language សម្រាប់ការអភិវឌ្ឍកម្មវិធីដែលមានប្រសិទ្ធភាព និងងាយស្រួល។");

            Tag php = new Tag();
            php.setName("php");
            php.setIsDeleted(false);
            php.setDescription("PHP គឺជា Server-Side Programming Language សម្រាប់ការអភិវឌ្ឍ Web Applications។");

            Tag rubyOnRails = new Tag();
            rubyOnRails.setName("ruby-on-rails");
            rubyOnRails.setIsDeleted(false);
            rubyOnRails.setDescription("Ruby on Rails គឺជា Framework សម្រាប់ការអភិវឌ្ឍ Web Applications ដោយប្រើ Ruby។");

            Tag aspNet = new Tag();
            aspNet.setName("asp.net");
            aspNet.setIsDeleted(false);
            aspNet.setDescription("ASP.NET គឺជា Framework របស់ Microsoft សម្រាប់ការអភិវឌ្ឍ Web Applications។");

            Tag django = new Tag();
            django.setName("django");
            django.setIsDeleted(false);
            django.setDescription("Django គឺជា Python Framework សម្រាប់ការអភិវឌ្ឍ Web Applications ដែលមានភាពលឿន និងសុវត្ថិភាព។");

            Tag flask = new Tag();
            flask.setName("flask");
            flask.setIsDeleted(false);
            flask.setDescription("Flask គឺជា Python Framework សាមញ្ញសម្រាប់ការអភិវឌ្ឍ Web Applications។");

            Tag fastApi = new Tag();
            fastApi.setName("fastapi");
            fastApi.setIsDeleted(false);
            fastApi.setDescription("FastAPI គឺជា Python Framework សម្រាប់ការអភិវឌ្ឍ APIs ដែលមានល្បឿនខ្ពស់។");

            Tag machineLearning = new Tag();
            machineLearning.setName("machine-learning");
            machineLearning.setIsDeleted(false);
            machineLearning.setDescription("Machine Learning គឺជា Branch របស់ AI ដែលផ្តោតលើការប្រើទិន្នន័យដើម្បីបណ្តុះម៉ូដែល។");

            Tag artificialIntelligence = new Tag();
            artificialIntelligence.setName("artificial-intelligence");
            artificialIntelligence.setIsDeleted(false);
            artificialIntelligence.setDescription("Artificial Intelligence គឺជាបច្ចេកវិទ្យាសម្រាប់ការបង្កើតប្រព័ន្ធដែលមានសមត្ថភាពដូចមនុស្ស។");

            Tag dataScience = new Tag();
            dataScience.setName("data-science");
            dataScience.setIsDeleted(false);
            dataScience.setDescription("Data Science គឺជា Science សម្រាប់ការវិភាគ និងប្រើប្រាស់ទិន្នន័យដើម្បីទទួលបានការយល់ដឹងថ្មី។");

            Tag pandas = new Tag();
            pandas.setName("pandas");
            pandas.setIsDeleted(false);
            pandas.setDescription("Pandas គឺជា Python Library សម្រាប់ការកែសម្រួល និងវិភាគទិន្នន័យ។");

            Tag numpy = new Tag();
            numpy.setName("numpy");
            numpy.setIsDeleted(false);
            numpy.setDescription("NumPy គឺជា Python Library សម្រាប់ការគណនាមេត្រិច និងការគណនាគណិតវិទ្យា។");

            Tag scikitLearn = new Tag();
            scikitLearn.setName("scikit-learn");
            scikitLearn.setIsDeleted(false);
            scikitLearn.setDescription("Scikit-learn គឺជា Python Library សម្រាប់ការអនុវត្ត Machine Learning។");

            Tag tensorflow = new Tag();
            tensorflow.setName("tensorflow");
            tensorflow.setIsDeleted(false);
            tensorflow.setDescription("TensorFlow គឺជា Framework សម្រាប់ការបង្កើត និងបណ្តុះ Machine Learning Models។");

            Tag pytorch = new Tag();
            pytorch.setName("pytorch");
            pytorch.setIsDeleted(false);
            pytorch.setDescription("PyTorch គឺជា Framework សម្រាប់ការបង្កើត Deep Learning Models ដោយប្រើ Python។");

            Tag spark = new Tag();
            spark.setName("apache-spark");
            spark.setIsDeleted(false);
            spark.setDescription("Apache Spark គឺជា Framework សម្រាប់ការគ្រប់គ្រង Big Data និងប្រតិបត្តិការព័ត៌មាន។");

            Tag hadoop = new Tag();
            hadoop.setName("hadoop");
            hadoop.setIsDeleted(false);
            hadoop.setDescription("Hadoop គឺជា Framework សម្រាប់ការរក្សាទិន្នន័យ និងការគ្រប់គ្រង Big Data។");


            Tag bigData = new Tag();
            bigData.setName("big-data");
            bigData.setIsDeleted(false);
            bigData.setDescription("Big Data គឺជាការគ្រប់គ្រង និងវិភាគទិន្នន័យដ៏មានបរិមាណធំដែលមិនអាចដំណើរការបានដោយប្រព័ន្ធទិន្នន័យធម្មតា។");

            Tag cassandra = new Tag();
            cassandra.setName("cassandra");
            cassandra.setIsDeleted(false);
            cassandra.setDescription("Apache Cassandra គឺជា Distributed Database សម្រាប់ទិន្នន័យដែលមានការលូតលាស់លឿន និងតម្រូវការក្នុងល្បឿនខ្ពស់។");

            Tag couchbase = new Tag();
            couchbase.setName("couchbase");
            couchbase.setIsDeleted(false);
            couchbase.setDescription("Couchbase គឺជា NoSQL Database សម្រាប់ការគ្រប់គ្រងទិន្នន័យដែលមានប្រសិទ្ធភាព និងសមត្ថភាពខ្ពស់។");

            Tag graphQLApi = new Tag();
            graphQLApi.setName("graphql-api");
            graphQLApi.setIsDeleted(false);
            graphQLApi.setDescription("GraphQL API គឺជាបច្ចេកទេសសម្រាប់ Query និង Manipulate Data ដោយប្រើ Language ដែលមាន Flexible Schema។");

            Tag expressJs = new Tag();
            expressJs.setName("expressjs");
            expressJs.setIsDeleted(false);
            expressJs.setDescription("Express.js គឺជា Node.js Framework សម្រាប់ការអភិវឌ្ឍ Backend Applications។");

            Tag nestJs = new Tag();
            nestJs.setName("nestjs");
            nestJs.setIsDeleted(false);
            nestJs.setDescription("NestJS គឺជា Node.js Framework ដែលផ្តោតលើការអភិវឌ្ឍ Backend Applications ដែលមានរចនាសម្ព័ន្ធទាន់សម័យ។");

            Tag sequelize = new Tag();
            sequelize.setName("sequelize");
            sequelize.setIsDeleted(false);
            sequelize.setDescription("Sequelize គឺជា ORM (Object-Relational Mapping) សម្រាប់ Node.js ដែលគាំទ្រ Databases ដូចជា MySQL, PostgreSQL។");

            Tag prisma = new Tag();
            prisma.setName("prisma");
            prisma.setIsDeleted(false);
            prisma.setDescription("Prisma គឺជា Next-Generation ORM សម្រាប់ការគ្រប់គ្រង Database សម្រាប់ JavaScript និង TypeScript។");

            Tag webpack = new Tag();
            webpack.setName("webpack");
            webpack.setIsDeleted(false);
            webpack.setDescription("Webpack គឺជា Module Bundler សម្រាប់ការចងវណ្ណកម្មវិធី Web Applications។");

            Tag rollup = new Tag();
            rollup.setName("rollup");
            rollup.setIsDeleted(false);
            rollup.setDescription("Rollup គឺជា Module Bundler សម្រាប់ JavaScript ដែលផ្តោតលើការបង្កើត Libraries និង Applications។");

            Tag vite = new Tag();
            vite.setName("vite");
            vite.setIsDeleted(false);
            vite.setDescription("Vite គឺជា Build Tool សម្រាប់ Frontend Applications ដោយផ្តោតលើល្បឿន និងប្រសិទ្ធភាព។");

            Tag babel = new Tag();
            babel.setName("babel");
            babel.setIsDeleted(false);
            babel.setDescription("Babel គឺជា JavaScript Compiler សម្រាប់ការបំលែង Code ទៅ Compatibility ខ្ពស់ក្នុង Browser។");

            Tag eslint = new Tag();
            eslint.setName("eslint");
            eslint.setIsDeleted(false);
            eslint.setDescription("ESLint គឺជា Tool សម្រាប់ពិនិត្យ និងបង្វែរ Code JavaScript និង TypeScript។");

            Tag prettier = new Tag();
            prettier.setName("prettier");
            prettier.setIsDeleted(false);
            prettier.setDescription("Prettier គឺជា Code Formatter សម្រាប់ការបង្វែររចនាបែបបទ Code ឱ្យមានភាពស្អាត និងមានលក្ខណៈស្របតាមក្បួន។");

            Tag tailwindUi = new Tag();
            tailwindUi.setName("tailwind-ui");
            tailwindUi.setIsDeleted(false);
            tailwindUi.setDescription("Tailwind UI គឺជា Component Library សម្រាប់ Tailwind CSS ដែលផ្តល់ Components ស្រាប់។");

            Tag materialUi = new Tag();
            materialUi.setName("material-ui");
            materialUi.setIsDeleted(false);
            materialUi.setDescription("Material-UI គឺជា React UI Framework ដែលផ្តោតលើរចនាបែប Material Design។");

            Tag antDesign = new Tag();
            antDesign.setName("ant-design");
            antDesign.setIsDeleted(false);
            antDesign.setDescription("Ant Design គឺជា UI Framework សម្រាប់ React ដែលផ្តោតលើការរចនាទាន់សម័យ។");

            Tag chakraUi = new Tag();
            chakraUi.setName("chakra-ui");
            chakraUi.setIsDeleted(false);
            chakraUi.setDescription("Chakra UI គឺជា React UI Framework សម្រាប់ការរចនាដែលមាន Flexible និង Accessible។");

            Tag vuetify = new Tag();
            vuetify.setName("vuetify");
            vuetify.setIsDeleted(false);
            vuetify.setDescription("Vuetify គឺជា UI Library សម្រាប់ Vue.js ដែលផ្តោតលើ Material Design។");

            Tag svelte = new Tag();
            svelte.setName("svelte");
            svelte.setIsDeleted(false);
            svelte.setDescription("Svelte គឺជា JavaScript Framework សម្រាប់ការរចនាបណ្ណកម្មវិធី Web Applications ដោយមិនចាំបាច់ Runtime។");

            Tag d3js = new Tag();
            d3js.setName("d3.js");
            d3js.setIsDeleted(false);
            d3js.setDescription("D3.js គឺជា JavaScript Library សម្រាប់ការបង្កើត Data Visualizations។");

            Tag chartJs = new Tag();
            chartJs.setName("chart.js");
            chartJs.setIsDeleted(false);
            chartJs.setDescription("Chart.js គឺជា JavaScript Library សម្រាប់ការបង្កើត Charts និង Graphs។");

            Tag threeJs = new Tag();
            threeJs.setName("three.js");
            threeJs.setIsDeleted(false);
            threeJs.setDescription("Three.js គឺជា JavaScript Library សម្រាប់ការបង្កើត 3D Visualizations នៅលើ Web។");

            Tag nextAuth = new Tag();
            nextAuth.setName("next-auth");
            nextAuth.setIsDeleted(false);
            nextAuth.setDescription("NextAuth គឺជា Authentication Library សម្រាប់ Next.js ដែលគាំទ្រ Providers ច្រើន។");

            Tag firebase = new Tag();
            firebase.setName("firebase");
            firebase.setIsDeleted(false);
            firebase.setDescription("Firebase គឺជា Backend-as-a-Service (BaaS) Platform ដែលផ្តល់សេវាកម្មទិន្នន័យ និង Authentication។");

            Tag supabase = new Tag();
            supabase.setName("supabase");
            supabase.setIsDeleted(false);
            supabase.setDescription("Supabase គឺជា Open Source Backend Platform សម្រាប់ការអភិវឌ្ឍកម្មវិធី Web និង Mobile។");


            Tag sanity = new Tag();
            sanity.setName("sanity");
            sanity.setIsDeleted(false);
            sanity.setDescription("Sanity គឺជា Content Platform សម្រាប់ការគ្រប់គ្រង និងប្រើប្រាស់ Content សម្រាប់ Web Applications។");

            Tag strapi = new Tag();
            strapi.setName("strapi");
            strapi.setIsDeleted(false);
            strapi.setDescription("Strapi គឺជា Headless CMS ដែលមានប្រសិទ្ធភាពសម្រាប់ការអភិវឌ្ឍ Backend API និង Content Management។");

            Tag swagger = new Tag();
            swagger.setName("swagger");
            swagger.setIsDeleted(false);
            swagger.setDescription("Swagger គឺជា Tool សម្រាប់ការបង្កើត និងឯកសារ API Specification។");

            Tag openApi = new Tag();
            openApi.setName("openapi");
            openApi.setIsDeleted(false);
            openApi.setDescription("OpenAPI Specification (OAS) គឺជា Format សម្រាប់ការរៀបចំ និងឯកសារ RESTful APIs។");

            Tag jsonWebToken = new Tag();
            jsonWebToken.setName("json-web-token");
            jsonWebToken.setIsDeleted(false);
            jsonWebToken.setDescription("JSON Web Token (JWT) គឺជា Standard សម្រាប់ការផ្ញើ Data ដែលបាន Signing រវាង Client និង Server។");

            Tag keycloak = new Tag();
            keycloak.setName("keycloak");
            keycloak.setIsDeleted(false);
            keycloak.setDescription("Keycloak គឺជា Open Source Identity និង Access Management Tool សម្រាប់ការគ្រប់គ្រង Authentication និង Authorization។");

            Tag sonarQube = new Tag();
            sonarQube.setName("sonarqube");
            sonarQube.setIsDeleted(false);
            sonarQube.setDescription("SonarQube គឺជា Tool សម្រាប់ការវិភាគ និងធ្វើ Code Quality និង Security Scanning។");

            Tag logstash = new Tag();
            logstash.setName("logstash");
            logstash.setIsDeleted(false);
            logstash.setDescription("Logstash គឺជា Tool សម្រាប់ប្រមូល, កែតម្រូវ, និងបញ្ជូន Logs ទៅ Elasticsearch ឬ Destination ផ្សេងទៀត។");

            Tag prometheus = new Tag();
            prometheus.setName("prometheus");
            prometheus.setIsDeleted(false);
            prometheus.setDescription("Prometheus គឺជា Monitoring System និង Time Series Database សម្រាប់ការចងតាម Metrics។");

            Tag grafana = new Tag();
            grafana.setName("grafana");
            grafana.setIsDeleted(false);
            grafana.setDescription("Grafana គឺជា Tool សម្រាប់ការបង្ហាញ Data Visualizations និងការគ្រប់គ្រង Dashboard។");

            Tag newRelic = new Tag();
            newRelic.setName("new-relic");
            newRelic.setIsDeleted(false);
            newRelic.setDescription("New Relic គឺជា Monitoring Tool សម្រាប់ការតាមដាន និងវិភាគការងាររបស់ Applications និង Infrastructure។");

            Tag datadog = new Tag();
            datadog.setName("datadog");
            datadog.setIsDeleted(false);
            datadog.setDescription("Datadog គឺជា Monitoring និង Analytics Platform សម្រាប់ Cloud Applications និង Infrastructure។");


            // Save all Tag
            forumTagRepository.saveAll(List.of(
                    java, spring, kotlin, go, python, javascript, typescript, html, css, bootstrap,
                    tailwind, sql, postgresql, mysql, mongodb, redis, elasticsearch, kafka, docker,
                    kubernetes, jenkins, aws, azure, gcp, ciCd, git, github, gitlab, bitbucket,
                    devops, restApi, graphql, microservices, hibernate, jpa, springSecurity, jwt,
                    oauth2, unitTesting, integrationTesting, jest, mocha, cypress, selenium,
                    flutter, dart, rust, scala, c, cpp, ruby, php, rubyOnRails, aspNet, django, flask, fastApi, machineLearning, artificialIntelligence,
                    dataScience, pandas, numpy, scikitLearn, tensorflow, pytorch, spark, hadoop, bigData,
                    cassandra, couchbase, graphQLApi, expressJs, nestJs, sequelize, prisma, webpack, rollup,
                    vite, babel, eslint, prettier, tailwindUi, materialUi, antDesign, chakraUi, vuetify,
                    svelte, d3js, chartJs, threeJs, nextAuth, firebase, supabase, sanity, strapi, swagger,
                    openApi, jsonWebToken, keycloak, sonarQube, logstash, prometheus, grafana, newRelic, datadog
            ));
        }
    }
}
