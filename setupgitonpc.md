
1. Check if git tool is already installed in your PC by typing `git --version` in your terminal.

2. If its installed, it will show the version otherwise install from this link https://git-scm.com/download/mac

3. Then configure the Full Name and email id associated with your github account using the following commands:
   
    `git config --global user.name "your_full_name"`
    
    `git config --global user.email "your_email_address"`
    
    `git config --global core.autocrlf input`
    
4. Next find out if ssh directory and keys exists in your system 
    Type: `cd ~/.ssh`

5. If it creates an error like this "No such file or directory", then create a directory `mkdir ~/.ssh` and then `cd ~/.ssh`.

6. Now type `ssh-keygen`. It will ask for location of ssh file. Press enter to keep the default path.

7. It will ask a paraphrase. Press enter for no paraphrase. One more enter for confirmation of paraphrase

8. It will say your keys have been saved. 

9. Next copy the ssh content to clipboard using `cat ~/.ssh/id_rsa.pub | pbcopy`.

10. Go to github, create a new ssh key and paste the copied ssh key.

11. Test whether your are connected using your ssh keys from mac terminal by `ssh -T git@github.com`

12. Enter 'yes' when prompted for an option yes/no. Now your authentication is successful.

  



