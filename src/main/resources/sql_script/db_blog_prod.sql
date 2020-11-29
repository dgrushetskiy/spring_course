--tables drop if exists
DROP TABLE IF EXISTS microblog.users_roles;
DROP TABLE IF EXISTS microblog.roles;
DROP TABLE IF EXISTS microblog.comments;
DROP TABLE IF EXISTS microblog.post_tag;
DROP TABLE IF EXISTS microblog.posts;
DROP TABLE IF EXISTS microblog.users;
DROP TABLE IF EXISTS microblog.tags;
--DROP INDEX IF EXISTS

--DROP SCHEMA
DROP SCHEMA IF EXISTS microblog;
--CREATE SCHEMA
CREATE SCHEMA IF NOT EXISTS microblog AUTHORIZATION root;
--table users  
CREATE  TABLE microblog.users ( 
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
ALTER TABLE microblog.users
  OWNER TO root;

COMMENT ON COLUMN microblog.users.pwd IS 'password';
--table roles
CREATE  TABLE microblog.roles ( 
	id                   bigserial  NOT NULL ,
	role_name            varchar(100)  NOT NULL ,
	CONSTRAINT pk_roles_id PRIMARY KEY ( id )
 )WITH (
  OIDS=FALSE
);
ALTER TABLE microblog.roles
  OWNER TO root;
--table users_roles
CREATE  TABLE microblog.users_roles ( 
	user_id              bigint  NOT NULL ,
	role_id              bigint  NOT NULL , 
	CONSTRAINT users_roles_pk PRIMARY KEY ( user_id, role_id )
 )WITH (
  OIDS=FALSE
);
ALTER TABLE microblog.users_roles
  OWNER TO root;
--table comments
CREATE  TABLE microblog.comments ( 
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
ALTER TABLE microblog.comments
  OWNER TO root; 
-- table posts
CREATE  TABLE microblog.posts ( 
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
ALTER TABLE microblog.posts
  OWNER TO root;  
-- table tags
CREATE  TABLE microblog.tags ( 
	id                   bigserial  NOT NULL ,
	tag_name             varchar(150)  NOT NULL ,
	CONSTRAINT pk_tags_id PRIMARY KEY ( id )
 )WITH (
  OIDS=FALSE
);
ALTER TABLE microblog.tags
  OWNER TO root; 
-- table post_tag 
CREATE  TABLE microblog.post_tag ( 	
	post_id              bigint  NOT NULL ,
	tag_id               bigint  NOT NULL ,
	CONSTRAINT post_tag_pk PRIMARY KEY ( post_id, tag_id )
 )WITH (
  OIDS=FALSE
);
ALTER TABLE microblog.post_tag
  OWNER TO root; 

ALTER TABLE microblog.comments ADD CONSTRAINT fk_comments_users FOREIGN KEY ( user_id ) REFERENCES microblog.users( id );

ALTER TABLE microblog.comments ADD CONSTRAINT fk_comments_posts FOREIGN KEY ( post_id ) REFERENCES microblog.posts( id );

ALTER TABLE microblog.post_tag ADD CONSTRAINT fk_post_tag_tags FOREIGN KEY ( tag_id ) REFERENCES microblog.tags( id );

ALTER TABLE microblog.post_tag ADD CONSTRAINT fk_post_tag_posts FOREIGN KEY ( post_id ) REFERENCES microblog.posts( id );

ALTER TABLE microblog.posts ADD CONSTRAINT fk_posts_users FOREIGN KEY ( user_id ) REFERENCES microblog.users( id );

ALTER TABLE microblog.users_roles ADD CONSTRAINT fk_users_roles_users FOREIGN KEY ( user_id ) REFERENCES microblog.users( id );

ALTER TABLE microblog.users_roles ADD CONSTRAINT fk_users_roles_roles FOREIGN KEY ( role_id ) REFERENCES microblog.roles( id );