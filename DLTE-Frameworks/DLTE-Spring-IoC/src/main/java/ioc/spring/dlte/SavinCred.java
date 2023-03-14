package ioc.spring.dlte;

public class SavinCred extends Datapool{

    public SavinCred(){
        getBranches().put("kathriguppe",765678987656L);
        getBranches().put("Moodbidri",567654565634L);
        getBranches().put("Bellari",3456787656734L);
        getBranches().put("banglore",987676767343L);
        getBranches().put("salem",9876766535344L);
        getBranches().put("kanchi",876763744455L);
        getBranches().put("Ujire",34873746455L);
    }

    @Override
    public long findContact(String branchName) {
        if(getBranches().containsKey(branchName))
            return getBranches().get(branchName);
        else
            return 0;
    }

    @Override
    public void deleteBranch(String branchName) {
        if(getBranches().containsKey(branchName)) {
            getBranches().remove(branchName);
            System.out.println(branchName+" has removed from Branch List");
        }
        else
            System.out.println("Can't remove/ invalid branch name");
    }
}
