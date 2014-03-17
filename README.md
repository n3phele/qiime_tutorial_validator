qiime_tutorial_validator
========================

What it is
========================
The qiime_tutorial_validator is a java program that does the rest calls required to test if everything related to the
QIIME Tutorial was properly installed and if it is working. The rest calls in the program create a n3phele service, run
the createQiimeImageHP.n nshell script to build the environment and runGeneratorForQIIMETutorial.n to generate the
scripts for the tutorial. After that the program will run the following tutorial scripts in order since the output from
one is the input for the next script: validate_mapping_file.py, split_libraries.py, pick_de_novu_otus.py,
make_otu_network.py and summarize_taxa_through_plots.py. If a script fails to complete, the program runs it again, until
it is successfully finished and its output is in the n3phele repository. A nshell script was also made to run this
program in n3phele, so if you don't know how to use a .jar file and you have a valid n3phele account you are able to run
it anyway.

How to use
========================
	Local - 1. Clone the repository.
		    2. Compile the program for the first time, so it will know which class is the main entry point of the project.
		    3. Create a runnable .jar file of the project, saving it in the same folder as you cloned the repository.
		    4. Open the command line in the path of the cloned repository.
		    5. Type java -jar "Name of the .jar you created" "Your username in n3phele" "Your password in n3phele" "The repository where you want to save the output of the program" (*).
		  
	N3phele - 1. Search the qiime_tutorial_validator.n nshell script.
			  2. Enter the required parameters. (*)
			  3. Select the proper account to run it.
			  4. Click "Run".


	(*)To see the program running properly, you need to enter the same account that you are logged in n3phele, otherwise it will try to run in the account that you entered and you won't be able to see if it worked or not.
