package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Main extends MemberFileConverter {

	@Override
	protected MemberExporter getMemberExporter( ) {
		// TODO
		MemberExporter exporter = new MemberExporterImpl();
		return exporter;
	}

	@Override
	protected MemberImporter getMemberImporter( ) {
		// TODO
		MemberImporter importer = new MemberImporterImpl();
		return importer;
	}

	@Override
	protected List< Member > getNonDuplicateMembers( List< Member > membersFromFile ) {

		// TODO
		Set<Member> set = new LinkedHashSet<>();
		set.addAll(membersFromFile);
		membersFromFile.clear();
		membersFromFile.addAll(set);


		return membersFromFile;
	}

	@Override
	protected Map< String, List< Member >> splitMembersByState( List< Member > validMembers ) {
		// TODO
		Map<String ,List<Member>> map= new HashMap<String ,List<Member>>();

		Set<String> states = new HashSet<>();

		for(Member mem: validMembers){
			List<Member> m = new ArrayList<>();


				if(map.keySet().size()==0){
					map.put(mem.getState(),Arrays.asList(mem));
					states.add(mem.getState());
					continue;
				}

				if(states.contains(mem.getState()) ){

					m.addAll(map.get(mem.getState()));
					m.add(mem);
					map.put(mem.getState(),m);

				}else{
					map.put(mem.getState(), Arrays.asList(mem));

				}
			states.add(mem.getState());


		}
//		System.out.println("User Syaye"+states);
		return map;
	}

	public static void main( String[] args ) throws Exception {



		new Main().convert(new File("Members.txt"),"./","outputFile.csv");

		//TODO
	}

}
