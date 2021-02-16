package org.launchcode.techjobs_oo.Tests;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class JobTest {

    Job jobOne;
    Job jobTwo;
    Job jobThree;
    Job jobFour;
    Job jobFive;
    Job jobSix;
    Job jobSeven;
    Job jobEight;
    Job duplicateJob;
    Job blankJob;

    @Before
    public void createJobs() {
        jobOne = new Job();
        jobTwo = new Job();
        jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobFour = new Job("", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobFive = new Job("Product tester", new Employer(""), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobSix = new Job("Product tester", new Employer("ACME"), new Location(""),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobSeven = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType(""), new CoreCompetency("Persistence"));
        jobEight = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency(""));
        duplicateJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        blankJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

    }

    @Test
    public void testSettingJobId() {
        assertTrue(jobTwo.getId() - jobOne.getId() == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(jobThree.getEmployer().getValue() == "ACME");
        assertTrue(jobThree.getLocation().getValue() == "Desert");
        assertTrue(jobThree.getPositionType().getValue() == "Quality control");
        assertTrue(jobThree.getCoreCompetency().getValue() == "Persistence");

        assertTrue(jobThree.getEmployer() instanceof Employer);
        assertTrue(jobThree.getLocation() instanceof Location);
        assertTrue(jobThree.getPositionType() instanceof PositionType);
        assertTrue(jobThree.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(jobThree.getId() == duplicateJob.getId());
    }

    @Test
    public void testStartAndEndWithBlankLine() {
        assertEquals('\n', jobThree.toString().charAt(0));
        int stringLength = jobThree.toString().length() - 1;
        assertEquals('\n', jobThree.toString().charAt(stringLength));
    }

    @Test
    public void testHasLabelsAndData() {
        assertEquals("\nID: " + jobThree.getId() + "\nName: Product tester\nEmployer: " +
                        "ACME\nLocation: " +
                        "Desert\nPosition Type: Quality control\nCore Competency: Persistence\n",
                jobThree.toString());
    }

    @Test
    public void testBlankFields() {
        assertEquals("\nID: " + jobFour.getId() + "\nName: No data available\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n",
                jobFour.toString());
        assertEquals("\nID: " + jobFive.getId() + "\nName: Product tester\nEmployer: " +
                        "No data available\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n",
                jobFive.toString());
        assertEquals("\nID: " + jobSix.getId() + "\nName: Product tester\nEmployer: " +
                        "ACME\nLocation: No data available\nPosition Type: Quality control\nCore Competency: Persistence\n",
                jobSix.toString());
        assertEquals("\nID: " + jobSeven.getId() + "\nName: Product tester\nEmployer: " +
                        "ACME\nLocation: Desert\nPosition Type: No data available\nCore Competency: Persistence\n",
                jobSeven.toString());
        assertEquals("\nID: " + jobEight.getId() + "\nName: Product tester\nEmployer: " +
                        "ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency:" +
                        " No data available\n",
                jobEight.toString());
    }

    @Test
    public void testBlankJob() {
        assertEquals("OOPS! This job does not seem to exist.", blankJob.toString());
//            //blank job isn't working. FIX ME!!!

    }
}