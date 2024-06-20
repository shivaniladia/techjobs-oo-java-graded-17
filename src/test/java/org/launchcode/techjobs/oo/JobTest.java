package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;
public class JobTest {
    String newline = System.lineSeparator();
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job emptyJobOne = new Job();
        Job emptyJobTwo = new Job();
        assertNotEquals(emptyJobOne.getId(), emptyJobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        String name = "Product tester";
        Employer employer = new Employer("ACME");
        Location location = new Location("Desert");
        PositionType position = new PositionType("Quality control");
        CoreCompetency coreCompetency = new CoreCompetency("Persistence");

        Job test_job = new Job(name, employer, location, position, coreCompetency);

        assertEquals(name, test_job.getName());
        assertEquals(employer, test_job.getEmployer());
        assertEquals(location, test_job.getLocation());
        assertEquals(position, test_job.getPositionType());
        assertEquals(coreCompetency, test_job.getCoreCompetency());

        assertTrue(employer instanceof Employer);
        assertTrue(location instanceof Location);
        assertTrue(position instanceof PositionType);
        assertTrue(coreCompetency instanceof CoreCompetency);
        assertTrue(test_job instanceof Job);
    }

    @Test
    public void testJobsForEquality() {
        Job emptyJobOne = new Job("Software Engineer", new Employer("Masterpass"), new Location("St Louis"), new PositionType("Developer"), new CoreCompetency("General"));
        Job emptyJobTwo = new Job("Software Engineer", new Employer("Masterpass"), new Location("St Louis"), new PositionType("Developer"), new CoreCompetency("General"));

        assertFalse(equals(emptyJobOne) != equals(emptyJobTwo));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobThree = new Job("Software Engineer", new Employer("Masterpass"), new Location("St Louis"), new PositionType("not master"), new CoreCompetency("General"));
        String testToString = newline +
                "ID: " + jobThree.getId() +
                "Name: " + jobThree.getName() +
                "Employer: " + jobThree.getEmployer() +
                "Location: " + jobThree.getLocation() +
                "Position Type: " + jobThree.getPositionType() +
                "Core Competency: " + jobThree.getCoreCompetency() + newline ;


        assertEquals(jobThree.toString().startsWith("\n") && jobThree.toString().endsWith("\n"), jobThree.toString().startsWith("\n") && jobThree.toString().endsWith("\n"));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {

        Job jobFour = new Job("Software Engineer", new Employer("Masterpass"), new Location("St Louis"), new PositionType("Development"), new CoreCompetency("General"));
        String stringJob = jobFour.toString();
        String testToString = System.lineSeparator() +
                        "ID: " + jobFour.getId() + System.lineSeparator() +
                        "Name: " + jobFour.getName() + System.lineSeparator() +
                        "Employer: " + jobFour.getEmployer().getValue() + System.lineSeparator() +
                        "Location: " + jobFour. getLocation().getValue() + System.lineSeparator() +
                        "Position Type: " + jobFour.getPositionType().getValue() + System.lineSeparator() +
                        "Core Competency: " + jobFour.getCoreCompetency().getValue() + System.lineSeparator()   ;

        assertEquals(testToString, stringJob);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job jobFive = new Job("Software Engineer", new Employer("Masterpass"), new Location(""), new PositionType(""), new CoreCompetency(""));
        String stringJob = jobFive.toString();
        String testToString = System.lineSeparator() +
                        "ID: " + jobFive.getId() +System.lineSeparator() +
                        "Name: " + jobFive.getName()  + System.lineSeparator() +
                        "Employer: " + jobFive.getEmployer() + System.lineSeparator() +
                        "Location: Data not available" + System.lineSeparator() +
                        "Position Type: Data not available" + System.lineSeparator() +
                        "Core Competency: Data not available" + System.lineSeparator() ;

        assertEquals(testToString, stringJob);
    }

}