build:
	clj -M -e "(compile 'app.core)" && ./uberdeps/package.sh	

play-ger-or-inf:
	java -cp target/project.jar clojure.main -m app.ger-or-inf
