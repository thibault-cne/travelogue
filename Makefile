JAVAFX_HOME = ~/jar/javafx-sdk-19

MAIN = Main.java

SRC_PATH = src/
OBJ_PATH = obj/

build:	
	@javac -classpath ${OBJ_PATH} --module-path ${JAVAFX_HOME}/lib --add-modules=javafx.base,javafx.controls ${SRC_PATH}travelogue/*.java -d ./${OBJ_PATH}
	@javac -classpath ${OBJ_PATH} --module-path ${JAVAFX_HOME}/lib --add-modules=javafx.base,javafx.controls ${SRC_PATH}*.java -d ./${OBJ_PATH}
	@echo "${BOLD}${CYAN}Compiling${S}${S} complete ⚙️"

run:
	@java -classpath ${OBJ_PATH} --module-path ${JAVAFX_HOME}/lib --add-modules=javafx.base,javafx.controls App
	@echo "${BOLD}${RED}Run${S}${S} complete"

re: clean build

jar:
	@rm -rf tp2-chenevie1u.jar
	@echo "${BOLD}${RED}Removed jar file${S}"
	@jar -cfm tp2-chenevie1u.jar manifest.MF -C ${OBJ_PATH} .
	@echo "${BOLD}${CYAN}Successfully created jar file${S}"

run-jar:
	@java --module-path ${JAVAFX_HOME}/lib --add-modules=javafx.base,javafx.controls -jar tp2-chenevie1u.jar

clean:
	@rm -rf ${OBJ_PATH}
	@rm -rf build/

S 		=		\033[0m
BOLD 	= 		\033[1m

RED 	= 		\033[31m
CYAN	=		\033[36m
