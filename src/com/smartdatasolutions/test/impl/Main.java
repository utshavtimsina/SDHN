package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Main extends MemberFileConverter {
   public MemberImporter imp;
	@Override
	protected MemberExporter getMemberExporter( ) {
		// TODO
		return null;
	}

	@Override
	protected MemberImporter getMemberImporter( ) {
		// TODO
		MemberImporter importer = new MemberImporterImpl();
		try{
			for (Member m: importer.importMembers(new File("Members.txt"))
			) {
				System.out.println(m.toString());
			}

		}catch (Exception e){
			e.printStackTrace();
		}
		return importer;
	}

	@Override
	protected List< Member > getNonDuplicateMembers( List< Member > membersFromFile ) {

		// TODO
		return null;
	}

	@Override
	protected Map< String, List< Member >> splitMembersByState( List< Member > validMembers ) {
		// TODO
		return null;
	}

	public static void main( String[] args ) {

		new Main().getMemberImporter();


		//TODO
	}

}
