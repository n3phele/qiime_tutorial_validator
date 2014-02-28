package restCalls;

import java.io.IOException;
import java.util.ArrayList;

import model.RunCommand;
import model.Variable;

import com.google.gson.Gson;

public class Main {

	private static boolean complete = false;
	private static boolean finalized = false;

	public static void main(String[] args) throws InterruptedException {

		NetClientExport exportFiles = new NetClientExport();
		NetClientImport importCommand = new NetClientImport();
		NetClientJson checkCommandState = new NetClientJson();
		NetClientRun runCommand = new NetClientRun();

		Gson gson = new Gson();

		ArrayList<Variable> varDefaultJson = new ArrayList<Variable>();
		ArrayList<Variable> varValidateMappingFile = new ArrayList<Variable>();
		ArrayList<Variable> varPickDeNovoOtus = new ArrayList<Variable>();
		ArrayList<Variable> varSplitLibraries = new ArrayList<Variable>();
		ArrayList<Variable> varMakeOtuNetwork = new ArrayList<Variable>();
		ArrayList<Variable> varSummarizeTaxaThroughPlots = new ArrayList<Variable>();

		Variable account = new Variable();
		account.name = "account";
		account.type = "Object";
		account.value = new String[] { "https://n3phele-dev.appspot.com/resources/account/2494009" };

		Variable notify = new Variable();
		notify.name = "notify";
		notify.type = "Boolean";
		notify.value = new String[] { "false" };

		Variable v = new Variable();
		v.name = "nshells.zip";
		v.type = "File";
		v.value = new String[] { "TestRepository:///" };
		varDefaultJson.add(v);
		varDefaultJson.add(notify);
		varDefaultJson.add(account);

		RunCommand defaultJson = new RunCommand();
		defaultJson.Variable = varDefaultJson;

		String defaultJsonJson = gson.toJson(defaultJson);

		Variable v1 = new Variable();
		v1.name = "verbose";
		v1.type = "Boolean";
		v1.value = new String[] { "false" };
		varValidateMappingFile.add(v1);

		v1 = new Variable();
		v1.name = "char_replace";
		v1.type = "String";
		v1.value = new String[] { "_" };
		varValidateMappingFile.add(v1);

		v1 = new Variable();
		v1.name = "not_barcoded";
		v1.type = "Boolean";
		v1.value = new String[] { "false" };
		varValidateMappingFile.add(v1);

		v1 = new Variable();
		v1.name = "variable_len_barcodes";
		v1.type = "Boolean";
		v1.value = new String[] { "false" };
		varValidateMappingFile.add(v1);

		v1 = new Variable();
		v1.name = "disable_primer_check";
		v1.type = "Boolean";
		v1.value = new String[] { "false" };
		varValidateMappingFile.add(v1);

		v1 = new Variable();
		v1.name = "added_demultiplex_field";
		v1.type = "String";
		v1.value = new String[] { "None" };
		varValidateMappingFile.add(v1);

		v1 = new Variable();
		v1.name = "suppress_html";
		v1.type = "Boolean";
		v1.value = new String[] { "false" };
		varValidateMappingFile.add(v1);

		v1 = new Variable();
		v1.name = "mapping_fp.file";
		v1.type = "File";
		v1.value = new String[] { "TestRepository:///Fasting_Map.txt" };
		varValidateMappingFile.add(v1);

		v1 = new Variable();
		v1.name = "output_dir.zip";
		v1.type = "File";
		v1.value = new String[] { "TestRepository:///QIIMEvalidateMappingFileRest/" };
		varValidateMappingFile.add(v1);

		varValidateMappingFile.add(notify);
		varValidateMappingFile.add(account);

		RunCommand validateMappingFile = new RunCommand();
		validateMappingFile.Variable = varValidateMappingFile;

		String validateMappingFileJson = gson.toJson(validateMappingFile);

		Variable v2 = new Variable();
		v2.name = "colorby";
		v2.type = "String";
		v2.value = new String[] { "" };
		varMakeOtuNetwork.add(v2);

		v2 = new Variable();
		v2.name = "background_color";
		v2.type = "String";
		v2.value = new String[] { "" };
		varMakeOtuNetwork.add(v2);

		v2 = new Variable();
		v2.name = "input_fp.file";
		v2.type = "File";
		v2.value = new String[] { "TestRepository:///QIIMEpickDeNovoOtusRest/otu_table.biom" };
		varMakeOtuNetwork.add(v2);

		v2 = new Variable();
		v2.name = "map_fname.file";
		v2.type = "File";
		v2.value = new String[] { "TestRepository:///QIIMEvalidateMappingFileRest/mapping_fp.file_corrected.txt" };
		varMakeOtuNetwork.add(v2);

		v2 = new Variable();
		v2.name = "output_dir.zip";
		v2.type = "File";
		v2.value = new String[] { "TestRepository:///QIIMEmakeOtuNetworkRest/" };
		varMakeOtuNetwork.add(v2);

		varMakeOtuNetwork.add(notify);
		varMakeOtuNetwork.add(account);

		RunCommand makeOtuNetwork = new RunCommand();
		makeOtuNetwork.Variable = varMakeOtuNetwork;

		String makeOtuNetworkJson = gson.toJson(makeOtuNetwork);

		Variable v3 = new Variable();
		v3.name = "remove_unassigned";
		v3.type = "Boolean";
		v3.value = new String[] { "false" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "minseqlength";
		v3.type = "Long";
		v3.value = new String[] { "200" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "maxseqlength";
		v3.type = "Long";
		v3.value = new String[] { "1000" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "trimseqlength";
		v3.type = "Boolean";
		v3.value = new String[] { "false" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "minqualscore";
		v3.type = "Long";
		v3.value = new String[] { "0" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "keepprimer";
		v3.type = "Boolean";
		v3.value = new String[] { "false" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "keepbarcode";
		v3.type = "Boolean";
		v3.value = new String[] { "false" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "maxambig";
		v3.type = "Long";
		v3.value = new String[] { "6" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "maxhomopolymer";
		v3.type = "Long";
		v3.value = new String[] { "6" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "maxprimermismatch";
		v3.type = "Long";
		v3.value = new String[] { "0" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "barcodetype";
		v3.type = "String";
		v3.value = new String[] { "golay_12" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "maxbarcodeerrors";
		v3.type = "Double";
		v3.value = new String[] { "1.5" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "startnumberingat";
		v3.type = "Long";
		v3.value = new String[] { "1" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "retain_unassigned_reads";
		v3.type = "Boolean";
		v3.value = new String[] { "false" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "disable_bc_correction";
		v3.type = "Boolean";
		v3.value = new String[] { "false" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "qual_score_window";
		v3.type = "Long";
		v3.value = new String[] { "0" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "discard_bad_windows";
		v3.type = "Boolean";
		v3.value = new String[] { "false" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "disable_primers";
		v3.type = "Boolean";
		v3.value = new String[] { "false" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "reverse_primers";
		v3.type = "String";
		v3.value = new String[] { "disable" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "reverse_primer_mismatches";
		v3.type = "Long";
		v3.value = new String[] { "0" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "record_qual_scores";
		v3.type = "Boolean";
		v3.value = new String[] { "false" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "median_length_filtering";
		v3.type = "String";
		v3.value = new String[] { "" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "added_demultiplex_field";
		v3.type = "String";
		v3.value = new String[] { "" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "truncate_ambi_bases";
		v3.type = "Boolean";
		v3.value = new String[] { "false" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "map.file";
		v3.type = "File";
		v3.value = new String[] { "TestRepository:///QIIMEvalidateMappingFileRest/mapping_fp.file_corrected.txt" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "fasta.repeat";
		v3.type = "File";
		v3.value = new String[] { "TestRepository:///Fasting_Example.fna" };
		varSplitLibraries.add(v3);

		v3 = new Variable();
		v3.name = "dirprefix.zip";
		v3.type = "File";
		v3.value = new String[] { "TestRepository:///QIIMEsplitLibrariesRest/" };
		varSplitLibraries.add(v3);
		varSplitLibraries.add(notify);
		varSplitLibraries.add(account);

		RunCommand splitLibraries = new RunCommand();
		splitLibraries.Variable = varSplitLibraries;

		String splitLibrariesJson = gson.toJson(splitLibraries);

		Variable v4 = new Variable();
		v4.name = "force";
		v4.type = "Boolean";
		v4.value = new String[] { "false" };
		varPickDeNovoOtus.add(v4);

		v4 = new Variable();
		v4.name = "print_only";
		v4.type = "Boolean";
		v4.value = new String[] { "false" };
		varPickDeNovoOtus.add(v4);

		v4 = new Variable();
		v4.name = "parallel";
		v4.type = "Boolean";
		v4.value = new String[] { "false" };
		varPickDeNovoOtus.add(v4);

		v4 = new Variable();
		v4.name = "jobs_to_start";
		v4.type = "Long";
		v4.value = new String[] { "1" };
		varPickDeNovoOtus.add(v4);

		v4 = new Variable();
		v4.name = "input_fp.file";
		v4.type = "File";
		v4.value = new String[] { "TestRepository:///QIIMEsplitLibrariesRest/seqs.fna" };
		varPickDeNovoOtus.add(v4);

		v4 = new Variable();
		v4.name = "output_dir.zip";
		v4.type = "File";
		v4.value = new String[] { "TestRepository:///QIIMEpickDeNovoOtusRest" };
		varPickDeNovoOtus.add(v4);

		varPickDeNovoOtus.add(notify);
		varPickDeNovoOtus.add(account);

		RunCommand pickDeNovoOtus = new RunCommand();
		pickDeNovoOtus.Variable = varPickDeNovoOtus;

		String pickDeNovoOtusJson = gson.toJson(pickDeNovoOtus);

		Variable v5 = new Variable();
		v5.name = "force";
		v5.type = "Boolean";
		v5.value = new String[] { "false" };
		varSummarizeTaxaThroughPlots.add(v5);

		v5 = new Variable();
		v5.name = "print_only";
		v5.type = "Boolean";
		v5.value = new String[] { "false" };
		varSummarizeTaxaThroughPlots.add(v5);

		v5 = new Variable();
		v5.name = "mapping_category";
		v5.type = "String";
		v5.value = new String[] { "" };
		varSummarizeTaxaThroughPlots.add(v5);

		v5 = new Variable();
		v5.name = "sort";
		v5.type = "Boolean";
		v5.value = new String[] { "false" };
		varSummarizeTaxaThroughPlots.add(v5);

		v5 = new Variable();
		v5.name = "otu_table_fp.file";
		v5.type = "File";
		v5.value = new String[] { "TestRepository:///QIIMEpickDeNovoOtusRest/otu_table.biom" };
		varSummarizeTaxaThroughPlots.add(v5);

		v5 = new Variable();
		v5.name = "output_dir.zip";
		v5.type = "File";
		v5.value = new String[] { "TestRepository:///QIIMEsummarizeTaxaThroughPlots" };
		varSummarizeTaxaThroughPlots.add(v5);

		varSummarizeTaxaThroughPlots.add(notify);
		varSummarizeTaxaThroughPlots.add(account);

		RunCommand summarizeTaxaThroughPlots = new RunCommand();
		summarizeTaxaThroughPlots.Variable = varSummarizeTaxaThroughPlots;

		String summarizeTaxaThroughPlotsJson = gson
				.toJson(summarizeTaxaThroughPlots);

		ArrayList<String> commandsGen = new ArrayList<>();
		commandsGen.add("make_otu_network.n");
		commandsGen.add("split_libraries.n");
		commandsGen.add("validate_mapping_file.n");
		commandsGen.add("pick_de_novo_otus.n");
		commandsGen.add("summarize_taxa_through_plots.n");

//		// SERVICE CREATION
//		runCommand.executeCommand(new String[] { "action", "StackService",
//				"arg", "", "name", "restService" }, "", defaultJsonJson);
//
//		// CREATING QIIME IMAGE
//		runCommand
//				.executeCommand(
//						new String[] {
//								"action",
//								"NShell",
//								"name",
//								"createQiimeImageRest",
//								"arg",
//								"https://n3phele-dev.appspot.com/resources/command/9265023#HPZone1",
//								"parent", runCommand.getLocationService() },
//						"", defaultJsonJson);
//
//		while (!complete) {
//			checkCommandState.getJson(runCommand.getLocationJsonResponse());
//			if (checkCommandState.getOutputState().equals("COMPLETE")
//					|| checkCommandState.getOutputFinalized().equals("true"))
//				complete = true;
//			Thread.sleep(60000);
//		}
//		System.out.println("Current State: "
//				+ checkCommandState.getOutputState());
//		System.out.println("Current Status: "
//				+ checkCommandState.getOutputFinalized());
//
//		importCommand.importCommand("runGeneratorForQIIMETutorial.n");
//
//		// RUNNING QIIME TUTORIAL SCRIPTS GENERATOR
//		runCommand
//				.executeCommand(
//						new String[] {
//								"action",
//								"NShell",
//								"name",
//								"runGeneratorForQIIMETutorialRest",
//								"arg",
//								"https://n3phele-dev.appspot.com/resources/command/5147476428324864#HPZone1",
//								"parent", runCommand.getLocationService() },
//						"tutorialOutput", defaultJsonJson);
//
//		complete = false;
//		while (!complete) {
//			checkCommandState.getJson(runCommand.getLocationJsonResponse());
//			if (checkCommandState.getOutputState().equals("COMPLETE")
//					|| checkCommandState.getOutputFinalized().equals("true"))
//				complete = true;
//			Thread.sleep(60000);
//		}
//		System.out.println("Current State: "
//				+ checkCommandState.getOutputState());
//		System.out.println("Current Status: "
//				+ checkCommandState.getOutputFinalized());
//
//		// EXPORTING SCRIPTS INTO A FOLDER IN YOUR PC
//		for (int i = 0; i < commandsGen.size(); i++) {
//			try {
//				exportFiles
//						.redirectExport(commandsGen.get(i), "tutorialOutput");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

		// RUNNING VALIDATE MAPPING FILE
		System.out.println("VALIDATE MAPPING FILE");
		complete = false;
		while (!complete) {
			finalized = false;
			runCommand
					.executeCommand(
							new String[] {
									"action",
									"Job",
									"name",
									"validate mapping file",
									"arg",
									"NShell https://n3phele-dev.appspot.com/resources/command/5703222647848960#HPZone1" },
							"", validateMappingFileJson);
			while (!finalized) {
				checkCommandState.getJson(runCommand.getLocationJsonResponse());
				if (checkCommandState.getOutputFinalized().equals("true"))
					finalized = true;
				Thread.sleep(30000);
			}
			if (checkCommandState.getOutputState().equals("COMPLETE"))
				complete = true;
		}
		System.out.println("Current State: "
				+ checkCommandState.getOutputState());
		System.out.println("Current Status: "
				+ checkCommandState.getOutputFinalized());

		// RUNNING SPLIT LIBRARIES
		System.out.println("SPLIT LIBRARIES");
		complete = false;
		while (!complete) {
			finalized = false;
			runCommand
					.executeCommand(
							new String[] {
									"action",
									"Job",
									"name",
									"split libraries",
									"arg",
									"NShell https://n3phele-dev.appspot.com/resources/command/4917007409479680#HPZone1" },
							"", splitLibrariesJson);
			while (!finalized) {
				checkCommandState.getJson(runCommand.getLocationJsonResponse());
				if (checkCommandState.getOutputFinalized().equals("true"))
					finalized = true;
				Thread.sleep(30000);
			}
			if (checkCommandState.getOutputState().equals("COMPLETE"))
				complete = true;
		}
		System.out.println("Current State: "
				+ checkCommandState.getOutputState());
		System.out.println("Current Status: "
				+ checkCommandState.getOutputFinalized());

		// RUNNING PICK DE NOVO OTUS
		System.out.println("PICK DE NOVO OTUS");
		complete = false;
		while (!complete) {
			finalized = false;
			runCommand
					.executeCommand(
							new String[] {
									"action",
									"Job",
									"name",
									"pick de novo otus",
									"arg",
									"NShell https://n3phele-dev.appspot.com/resources/command/4668169889251328#HPZone1" },
							"", pickDeNovoOtusJson);
			while (!finalized) {
				checkCommandState.getJson(runCommand.getLocationJsonResponse());
				if (checkCommandState.getOutputFinalized().equals("true"))
					finalized = true;
				Thread.sleep(30000);
			}
			if (checkCommandState.getOutputState().equals("COMPLETE"))
				complete = true;
		}
		System.out.println("Current State: "
				+ checkCommandState.getOutputState());
		System.out.println("Current Status: "
				+ checkCommandState.getOutputFinalized());

		// RUNNING MAKE OTU NETWORK
		System.out.println("MAKE OTU NETWORK");
		complete = false;
		while (!complete) {
			finalized = false;
			runCommand
					.executeCommand(
							new String[] {
									"action",
									"Job",
									"name",
									"make otu network",
									"arg",
									"NShell https://n3phele-dev.appspot.com/resources/command/5726071873863680#HPZone1" },
							"", makeOtuNetworkJson);
			while (!finalized) {
				checkCommandState.getJson(runCommand.getLocationJsonResponse());
				if (checkCommandState.getOutputFinalized().equals("true"))
					finalized = true;
				Thread.sleep(30000);
			}
			if (checkCommandState.getOutputState().equals("COMPLETE"))
				complete = true;
		}
		System.out.println("Current State: "
				+ checkCommandState.getOutputState());
		System.out.println("Current Status: "
				+ checkCommandState.getOutputFinalized());

		// RUNNING SUMMARIZE TAXA THROUGH PLOTS
		System.out.println("SUMMARIZE TAXA THROUGH PLOTS");
		complete = false;
		while (!complete) {
			finalized = false;
			runCommand
					.executeCommand(
							new String[] {
									"action",
									"Job",
									"name",
									"summarize taxa through plots",
									"arg",
									"NShell https://n3phele-dev.appspot.com/resources/command/4594914927050752#HPZone1" },
							"", summarizeTaxaThroughPlotsJson);
			while (!finalized) {
				checkCommandState.getJson(runCommand.getLocationJsonResponse());
				if (checkCommandState.getOutputFinalized().equals("true"))
					finalized = true;
				Thread.sleep(30000);
			}
			if (checkCommandState.getOutputState().equals("COMPLETE"))
				complete = true;
		}
		System.out.println("Current State: "
				+ checkCommandState.getOutputState());
		System.out.println("Current Status: "
				+ checkCommandState.getOutputFinalized());

		}
}
