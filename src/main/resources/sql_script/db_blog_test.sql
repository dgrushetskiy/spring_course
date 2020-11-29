--tables drop if exists
DROP TABLE IF EXISTS test.users_roles;
DROP TABLE IF EXISTS test.roles;
DROP TABLE IF EXISTS test.comments;
DROP TABLE IF EXISTS test.post_tag;
DROP TABLE IF EXISTS test.posts;
DROP TABLE IF EXISTS test.users;
DROP TABLE IF EXISTS test.tags;
--DROP INDEX IF EXISTS

--DROP SCHEMA
DROP SCHEMA IF EXISTS test;
--CREATE SCHEMA
CREATE SCHEMA IF NOT EXISTS test AUTHORIZATION root;
--table users  
CREATE  TABLE test.users ( 
	id                   bigserial  NOT NULL ,
	username             varchar(150)  NOT NULL ,
	pwd                  varchar(150)  NOT NULL ,
	first_name           varchar(150)  NOT NULL ,
	last_name            varchar(150)  NOT NULL ,
	created_at           timestamp(0) DEFAULT current_timestamp  ,
	update_at            timestamp(0) DEFAULT current_timestamp  ,
	is_active            boolean DEFAULT false NOT NULL ,
	CONSTRAINT pk_users_id PRIMARY KEY ( id ),
	CONSTRAINT unq_users_username UNIQUE ( username ) 
 )WITH (
  OIDS=FALSE
);
ALTER TABLE test.users
  OWNER TO root;

COMMENT ON COLUMN test.users.pwd IS 'password';
--table roles
CREATE  TABLE test.roles ( 
	id                   bigserial  NOT NULL ,
	role_name            varchar(100)  NOT NULL ,
	CONSTRAINT pk_roles_id PRIMARY KEY ( id )
 )WITH (
  OIDS=FALSE
);
ALTER TABLE test.roles
  OWNER TO root;
--table users_roles
CREATE  TABLE test.users_roles ( 
	user_id              bigint  NOT NULL ,
	role_id              bigint  NOT NULL , 
	CONSTRAINT user_roles_pk PRIMARY KEY ( user_id, role_id )
 )WITH (
  OIDS=FALSE
);
ALTER TABLE test.users_roles
  OWNER TO root;
--table comments
CREATE  TABLE test.comments ( 
	id                   bigserial  NOT NULL ,
	user_id              bigint  NOT NULL ,
	post_id              bigint  NOT NULL ,
	content              text   ,
	created_at           timestamp(0) DEFAULT current_timestamp NOT NULL ,
	updated_at           timestamp(0) DEFAULT current_timestamp NOT NULL ,
	CONSTRAINT pk_comments_id PRIMARY KEY ( id )
 )WITH (
  OIDS=FALSE
);
ALTER TABLE test.comments
  OWNER TO root; 
-- table posts
CREATE  TABLE test.posts ( 
	id                   bigserial  NOT NULL ,
	user_id              bigint  NOT NULL ,
	title                varchar(150)  NOT NULL ,
	content              text   ,
	created_at           timestamp(0) DEFAULT current_timestamp NOT NULL ,
	updated_at           timestamp(0) DEFAULT current_timestamp NOT NULL ,
	CONSTRAINT pk_posts_id PRIMARY KEY ( id )
 )WITH (
  OIDS=FALSE
);
ALTER TABLE test.posts
  OWNER TO root;  
-- table tags
CREATE  TABLE test.tags ( 
	id                   bigserial  NOT NULL ,
	tag_name             varchar(150)  NOT NULL ,
	CONSTRAINT pk_tags_id PRIMARY KEY ( id )
 )WITH (
  OIDS=FALSE
);
ALTER TABLE test.tags
  OWNER TO root; 
-- table post_tag 
CREATE  TABLE test.post_tag ( 	
	post_id              bigint  NOT NULL ,
	tag_id               bigint  NOT NULL ,
	CONSTRAINT post_tag_pk PRIMARY KEY ( post_id, tag_id )
 )WITH (
  OIDS=FALSE
);
ALTER TABLE test.post_tag
  OWNER TO root; 

ALTER TABLE test.comments ADD CONSTRAINT fk_comments_users FOREIGN KEY ( user_id ) REFERENCES test.users( id );

ALTER TABLE test.comments ADD CONSTRAINT fk_comments_posts FOREIGN KEY ( post_id ) REFERENCES test.posts( id );

ALTER TABLE test.post_tag ADD CONSTRAINT fk_post_tag_tags FOREIGN KEY ( tag_id ) REFERENCES test.tags( id );

ALTER TABLE test.post_tag ADD CONSTRAINT fk_post_tag_posts FOREIGN KEY ( post_id ) REFERENCES test.posts( id );

ALTER TABLE test.posts ADD CONSTRAINT fk_posts_users FOREIGN KEY ( user_id ) REFERENCES test.users( id );

ALTER TABLE test.users_roles ADD CONSTRAINT fk_users_roles_users FOREIGN KEY ( user_id ) REFERENCES test.users( id );

ALTER TABLE test.users_roles ADD CONSTRAINT fk_users_roles_roles FOREIGN KEY ( role_id ) REFERENCES test.roles( id );