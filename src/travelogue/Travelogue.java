/* ************************************************************************** */
/*                                                                            */
/*                                                                            */
/*   Travelogue.java                                                          */
/*                                                                            */
/*   By: Thibault Cheneviere <thibault.cheneviere@telecomnancy.eu>            */
/*                                                                            */
/*   Created: 2022/11/24 09:34:31 by Thibault Cheneviere                      */
/*   Updated: 2022/11/24 11:51:24 by Thibault Cheneviere                      */
/*                                                                            */
/* ************************************************************************** */

package travelogue;

import java.util.ArrayList;
import java.util.Date;

public class Travelogue {
	private Date dateDeb;
	private Date dateEnd;
	private String title;
	private String auteur;
	private ArrayList<String> participants = new ArrayList<String>();
	private ArrayList<Day> days = new ArrayList<Day>();

	public Travelogue(String jsonPath) {
		
	}
}
